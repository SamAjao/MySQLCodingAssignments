/*
// Program: Promineo Tech Backend Java Development Course
// Author:  Samuel Ajao
// Subject:  Java- MySQL Project
// Create Date: June 13, 2024
//
*/
package projects.service;

import projects.dao.ProjectDao;
import projects.entity.Project;

public class ProjectService {
	private ProjectDao projectDao = new ProjectDao();
	
	/*
	 *  This method simply calls the DAO class to insert a project row.
	 *  
	 *  @param project The {@ling Project} object.
	 *  @return The Project object with the newly generated primary key value.
	 */
	public Project addProject(Project project) {
		return projectDao.insertProject(project);
	}
}
