/**
 * Created by mgq on 2016/2/29.
 * 测试闭包
 */
window.onload= function () {
    //foo(2);//01
    //02
    var bar = foo(2); // bar 现在是一个闭包
    bar(10);

}
//当function里嵌套function时，内部的function可以访问外部function里的变量。不管执行多少次，都会alert 16，因为bar能访问foo的参数x，也能访问foo的变量tmp。
//但，这还不是闭包
//01
function foo(x) {
    var tmp = 3;
    function bar(y) {
        alert(x + y + (++tmp));
    }
    bar(10);
}
//内部function会close-over外部function的变量直到内部function结束。
//02
function foo(x) {
    var tmp = 3;
    return function (y) {
        alert(x + y + (++tmp));
    }
}
