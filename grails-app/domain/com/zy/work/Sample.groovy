package com.zy.work

/**
 * for test
 */
class Sample {
    String name
    String desc
    static constraints = {
        name blank: false, unique: true
        desc nullable:true,maxSize: 3000
    }

    static mapping = {
        desc column: 'sampledesc'
    }
}
