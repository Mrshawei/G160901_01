package com.sw.test;

import org.activiti.engine.*;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

import java.util.List;

public class TestActiviti {
    ProcessEngine processEngine= ProcessEngines.getDefaultProcessEngine();


    @Test
    public void testCreateTable(){
        //使用Activiti工作引擎 完成表的创建

        System.out.println("数据表创建完成");
    }

    //部署流程任务
    @Test
    public void deployMentProcess(){
        RepositoryService repositoryService=processEngine.getRepositoryService();
        //部署流程
        Deployment deployment = repositoryService.createDeployment().name("请假流程").addClasspathResource("diagrams/askforleave.bpmn").deploy();

        System.out.println("流程ID："+deployment.getId());
    }

    //启动流程实例
    @Test
    public void startProcessInstance(){
        //运行时的服务
        RuntimeService runtimeService=processEngine.getRuntimeService();
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("askforleave");
        System.out.println("任务实例ID："+processInstance.getId());

    }

    //完成任务
    @Test
    public void completeProcess(){
        TaskService taskService=processEngine.getTaskService();
        taskService.complete("35002");
    }

   //查询流程定义
    @Test
    public  void queryProcessDef(){
        RepositoryService repositoryService=processEngine.getRepositoryService();
        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().list();
        for (ProcessDefinition definition : list) {
            System.out.println("流程定义的key:"+definition.getKey());
            System.out.println("流程定义的名称:"+definition.getName());
            System.out.println("定义的id"+definition.getId());
            System.out.println(definition.getDeploymentId());
        }
    }

    //删除流程
    @Test
    public void deleteProcess(){
        RepositoryService repositoryService=processEngine.getRepositoryService();
        repositoryService.deleteDeployment("25001",true);
    }

    //查看流程实例
    @Test
    public void queryAllProcessIns(){
        RuntimeService runtimeService=processEngine.getRuntimeService();
        List<ProcessInstance> list = runtimeService.createProcessInstanceQuery().list();
        for (ProcessInstance instance : list) {
            System.out.println("流程实例ID："+instance.getId());

        }
    }

    //查询历史流程
    @Test
    public void queryHistoryProcess(){
        HistoryService historyService=processEngine.getHistoryService();
        List<HistoricProcessInstance> list = historyService.createHistoricProcessInstanceQuery().list();
        for (HistoricProcessInstance instance : list) {
            System.out.println("历史流程编号:"+instance.getId());
            System.out.println("流程名称:"+instance.getName());
            System.out.println("流程启动时间:"+instance.getStartTime());
            System.out.println("流程完成时间:"+instance.getEndTime());
            System.out.println("流程消耗时间:"+instance.getDurationInMillis());
        }
    }

    //查询历史任务
    @Test
    public void queryHistoryTask(){
        HistoryService historyService=processEngine.getHistoryService();
        List<HistoricTaskInstance> list = historyService.createHistoricTaskInstanceQuery().taskAssignee("张柯基").list();
        for (HistoricTaskInstance taskInstance : list) {
            System.out.println("启动时间:"+taskInstance.getStartTime());
            System.out.println("结束时间:"+taskInstance.getEndTime());

        }
    }


    //设置请假时间
    @Test
    public void setProcessValue(){
        TaskService taskService=processEngine.getTaskService();
        Task task = taskService.createTaskQuery().taskAssignee("张柯基").singleResult();
        taskService.setVariable(task.getId(),"请假时间",3);
    }

    //获取任务的值
    @Test
    public void getProcessValue(){
        TaskService taskService=processEngine.getTaskService();
        Task task = taskService.createTaskQuery().taskAssignee("张柯基").singleResult();
        Object obj=taskService.getVariable(task.getId(),"请假时间");
        System.out.println(obj);
    }


}
