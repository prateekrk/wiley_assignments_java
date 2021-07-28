package com.prateek.budget;

class Project{
    int projectId,budget;
    String projectName;
    Project(int projectId,int budget,String projectName){
        this.projectId=projectId;
        this.budget=budget;
        this.projectName=projectName;
    }

    public int getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public int getBudget() {
        return budget;
    }
}
