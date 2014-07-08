import com.zy.work.Sample
import com.zy.work.Store
import com.zy.work.Task

class BootStrap {

    def init = { servletContext ->

        new Sample(name:'s1',desc:'d1').save()
        new Sample(name:'s2',desc:'d2').save()
        new Sample(name:'s3',desc:'d3').save()
        new Sample(name:'s4',desc:'d4').save()
        new Sample(name:'s5',desc:'d5').save()
        new Sample(name:'s6',desc:'d6').save()
        new Sample(name:'s7',desc:'d7').save()
        new Sample(name:'s8',desc:'d8').save()
        new Sample(name:'s9',desc:'d19').save()
        new Sample(name:'s10',desc:'d10').save()
        new Sample(name:'s11',desc:'d11').save()
        new Sample(name:'s12',desc:'d12').save()
        new Sample(name:'s13',desc:'d13').save()


        Store s1=new Store(storeName:'store1',storeAddress:'add1',storeContact:'a1',storeContactPhone:'124',storeNum:'432');
        Store s2=new Store(storeName:'store2',storeAddress:'add1',storeContact:'a1',storeContactPhone:'1324',storeNum:'23');
        Store s3=new Store(storeName:'store3',storeAddress:'add1',storeContact:'a2',storeContactPhone:'1224',storeNum:'345');
        Store s4=new Store(storeName:'store4',storeAddress:'add1',storeContact:'a2',storeContactPhone:'1424',storeNum:'232');

        s1.save();
        s2.save();
        s3.save();
        s4.save();

        Task task1 = new Task(dept:'d1',executor:'ss',taskStarter:'kk',startTime:'09-12-02',planTo:'09-12-03',store: s1)
        Task task2 = new Task(dept:'d2',executor:'ss2',taskStarter:'kk2',startTime:'09-12-02',planTo:'09-12-03',store: s1)
        task1.save()
        task2.save()

    }
    def destroy = {
    }
}
