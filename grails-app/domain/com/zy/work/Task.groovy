package com.zy.work
/**
 *
 * 任务
 *
 */
class Task {
    //  事业部
    String dept

    //执行人
    String executor

    //类型：检查、验收、整改、判定
    String taskType = "检查"

    //备注
    String desc

    //发起人
    String taskStarter

    //发起日期
    String startTime

    //计划完成时间
    String planTo

    //状态：未开始，已完成
    String taskState = "未开始"

    //结论摘要
    String taskConclusion

    static belongsTo = [store: Store]

    static mapping = {
        desc column: 'taskdesc'
    }

    static constraints = {
        //name blank: false, unique: true
        dept nullable:true
        executor nullable:false
        taskType inList: ["检查","验收","整改","判定"]
        desc nullable:true,maxSize: 3000

        taskStarter nullable:false
        startTime nullable:false
        planTo nullable:true
        taskState inList: ["未开始","已完成"]
        taskConclusion nullable:true,maxSize: 3000
    }
}
