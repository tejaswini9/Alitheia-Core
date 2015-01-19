/*
 * This file is part of the Alitheia system, developed by the SQO-OSS
 * consortium as part of the IST FP6 SQO-OSS project, number 033331.
 *
 * Copyright 2008 - 2010 - Organization for Free and Open Source Software,  
 *                Athens, Greece.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *
 *     * Redistributions in binary form must reproduce the above
 *       copyright notice, this list of conditions and the following
 *       disclaimer in the documentation and/or other materials provided
 *       with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */

package eu.sqooss.service.db;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import eu.sqooss.core.AlitheiaCore;
import eu.sqooss.service.cluster.ClusterNodeActionException;
import eu.sqooss.service.db.DAObject;
import eu.sqooss.service.logging.Logger;

/**
 * A node in a Alitheia Core cluster installation
 * 
 * @assoc 1 - n StoredProject
 */
@XmlRootElement(name="clusternode")
@Entity
@Table(name="CLUSTERNODE")
public class ClusterNode extends DAObject {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="CLUSTERNODE_ID")
    @XmlElement
    private long id;
  
    @Column(name="CLUSTERNODE_NAME")
    @XmlElement
    private String name;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy="clusternode",  fetch = FetchType.LAZY)
    private Set<StoredProject> projects;
    
    // Nothing to do here
    public ClusterNode(){}
    
    public ClusterNode(String servername){ 
    	setName(servername);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public Set<StoredProject> getProjects() {
        return projects;
    }

    public void setProjects(Set<StoredProject> projects) {
        this.projects = projects;
    }
    
    public static ClusterNode getClusteNodeByName(String name) {
        DBService dbs = AlitheiaCore.getInstance().getDBService();
        
        Map<String,Object> parameterMap = new HashMap<String,Object>();
        parameterMap.put("name",name);
        List<ClusterNode> cnList = dbs.findObjectsByProperties(ClusterNode.class, parameterMap);
        return (cnList == null || cnList.isEmpty()) ? null : cnList.get(0);
    }
    
    public static ClusterNode thisNode() {
        String hostname;
        try {
            java.net.InetAddress localMachine = java.net.InetAddress.getLocalHost();
            hostname = localMachine.getHostName();
        }
        catch(java.net.UnknownHostException ex) {
            hostname = "unknown host";
        }       
        
        return getClusteNodeByName(hostname);
    }
    
    /**
     * Assign a StoredProject to a ClusterNode
     * Reasonable causes of failure:
     *  1.NULL passed server
     *  2.NULL passed project
     *  3.Assignment is locked (server is working on project)
     *  
     * @param node the cluster node target
     * @param project stored project to assign 
     * @return
     */
    public boolean assignProject(Logger logger, ClusterNode node, StoredProject project) throws ClusterNodeActionException {
    	// check if valid server passed
        if (node==null) {
    		throw new ClusterNodeActionException("Request to assign a project to a null clusternode");
    	}
    	// check if valid project passed
    	if (project==null) {
    		throw new ClusterNodeActionException("Request to assign a null project to a clusternode");
    	}

        try {          
        	// check if project is already assigned to any ClusterNode
            ClusterNode assignment = project.getClusternode();
            if (assignment == null) {
                // new project assignment
                logger.info("Assigning project " + project.getName() + " to "
                        + node.getName());
                node.getProjects().add(project);
            } else {
                logger.info("Moving project " + project.getName() + " from "
                        + assignment.getName() + " to "
                        + node.getName());
                if (assignment.getId() == node.getId()) {
                    logger.info("No need to move " + project.getName()
                            + " - Already assigned!");
                    return true;
                }
            }
        } catch (Exception e) {
            throw new ClusterNodeActionException("Failed to assign project ["
                    + project.getName() + "] to clusternode [" + node.getName()
                    + "]");
        }
    	return true;
    }
    
}
