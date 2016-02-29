/**
 * Created by mgq on 2016/2/24.
 * 创建对象
 */
window.onload=function(){

    //定义对象  1
    var person=new Object();
    person.name='张三';
    document.writeln(person.name);

    //2
    var cat={
        name:'tom',
        color:'blue'
    };
    document.writeln(cat.name+'颜色'+cat.color);

    //3 构造方法
    var dogg=new dog('大黄');
    document.writeln(dogg.name);
    dogg.bark();

    //4 原型方式
    var apple1=new apple();
    document.writeln(apple1.name);
    document.writeln(apple1.color);

    //5.构造方法+原型方式
    var dazhong=new car('golf');
    document.writeln(dazhong.name);
    dazhong.run(dazhong.name,'10公里');

    //6 工厂模式
    var mouse=mouseF('jim',2);
    document.writeln(mouse.name);
    document.writeln(mouse.weight);
    mouse.squeak();

    //7 动态原型方式
    var desk01=new Desk('小桌子','red');
    document.writeln(desk01.seat());
    for(var d in desk01){//遍历对象中所有属性
        document.writeln(d);
    }

}

function dog(name){
    this.name=name;
    this.bark=function(){
        document.write(name+'wwwww');
    }
}

function apple(name,color){

}
apple.prototype.name='apple1';
apple.prototype.color='red';


function car(name){
    this.name=name;
}
car.prototype.run= function (name,far) {
    document.writeln(name+'跑了'+far);
}

function mouseF(name,weight){
    var mouse=new Object();
    mouse.name=name;
    mouse.weight=weight;
    mouse.squeak=function(){
        document.writeln('I am '+name+' and i weight '+weight+'kg');
    }
    return mouse;
}

function Desk(){
    this.name=arguments[0];//表示调用者传递的第一个参数
    this.color=arguments[1];
    if(typeof Desk.seat=='undefined'){
        Desk.prototype.seat=function(){
            return this.name;
        }
        Desk.seat=true;
    }

}
