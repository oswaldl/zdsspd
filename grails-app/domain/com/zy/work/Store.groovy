package com.zy.work
/**
 * 门店
 */
class Store {
    //门店名称
    String storeName

    //门店地址
    String storeAddress

    //门店联系人
    String storeContact

    //门店联系人电话
    String storeContactPhone

    //门店编号
    String storeNum

    static hasMany=[tasks:Task]

    static constraints = {
        storeName blank: false, unique: true
        storeAddress nullable:true,maxSize: 3000
        storeContact nullable:true
        storeContactPhone nullable:true
        storeNum nullable:true
    }
}
