package com.taskmanage.tasks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

import com.taskmanage.tasks.model.Project;
import com.taskmanage.tasks.repo.ProjectRepository;

import java.util.List;
import java.util.Optional;

// @Service
// public class ProjectService {
//     @Autowired
//     private ProjectRepository projectRepository;

//     public List<Project> getAllProjects() {
//         return projectRepository.findAll();
//     }

//     public Optional<Project> getProjectById(Long projectId) {
//         return projectRepository.findById(projectId);
//     }

//     public Project saveProject(Project project) {
//         return projectRepository.save(project);
//     }

//     public void deleteProject(Long projectId) {
//         projectRepository.deleteById(projectId);
//     }

//     public Project updateProject(Long projectId, Project projectDetails) {
//         Optional<Project> projectOptional = projectRepository.findById(projectId);
//         if (projectOptional.isPresent()) {
//             Project project = projectOptional.get();
//             project.setProjectName(projectDetails.getProjectName());
//             project.setDueDate(projectDetails.getDueDate());
//             project.setManager(projectDetails.getManager());
//             return projectRepository.save(project);
//         } else {
//             throw new RuntimeException("Project not found with id " + projectId);
//         }
//     }

//     public List<Project> getProjectsByManagerId(Long managerId) {
//         return projectRepository.findByManagerUserId(managerId);
//     }
// }

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Optional<Project> getProjectById(Long projectId) {
        return projectRepository.findById(projectId);
    }

    public Project updateProject(Long projectId, Project projectDetails) {
        Project project = projectRepository.findById(projectId).orElseThrow();
        project.setProjectName(projectDetails.getProjectName());
        project.setDescription(projectDetails.getDescription());
        project.setDueDate(projectDetails.getDueDate());
        project.setManager(projectDetails.getManager());
        return projectRepository.save(project);
    }

    public void deleteProject(Long projectId) {
        projectRepository.deleteById(projectId);
    }
}
