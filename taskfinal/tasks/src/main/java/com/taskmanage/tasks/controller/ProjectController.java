package com.taskmanage.tasks.controller;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.taskmanage.tasks.model.Project;
// import com.taskmanage.tasks.repo.ProjectRepository;
import com.taskmanage.tasks.service.ProjectService;

import java.util.List;
import java.util.Optional;

// @RestController
// @RequestMapping("/api/projects")
// public class ProjectController {

//     @Autowired
//     private ProjectRepository projectRepository;

//     @Autowired
//     private ProjectService projectService;

//     @GetMapping
//     public List<Project> getAllProjects() {
//         return projectService.getAllProjects();
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
//         Optional<Project> project = projectService.getProjectById(id);
//         return project.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//     }

//     @PostMapping
//     public ResponseEntity<Project> createProject(@RequestBody Project project) {
//         Project savedProject = projectRepository.save(project);
//         return ResponseEntity.status(HttpStatus.CREATED).body(savedProject);
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project projectDetails) {
//         try {
//             Project updatedProject = projectService.updateProject(id, projectDetails);
//             return ResponseEntity.ok(updatedProject);
//         } catch (RuntimeException e) {
//             return ResponseEntity.notFound().build();
//         }
//     }

//     @DeleteMapping("/{id}")
//     public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
//         projectService.deleteProject(id);
//         return ResponseEntity.noContent().build();
//     }

//     @GetMapping("/manager/{managerId}")
//     public List<Project> getProjectsByManagerId(@PathVariable Long managerId) {
//         return projectService.getProjectsByManagerId(managerId);
//     }
// }

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return projectService.saveProject(project);
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public Optional<Project> getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }

    @PutMapping("/{id}")
    public Project updateProject(@PathVariable Long id, @RequestBody Project projectDetails) {
        return projectService.updateProject(id, projectDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
    }
}
