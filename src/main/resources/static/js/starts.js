window.init()
function init(){
    WHeight=window.innerHeight;
    WWidth=window.innerWidth;
    dots=[];
    drawInit();
}
function drawInit(){
    container_canvas = document.getElementById("mycanvas");
    canvas = document.createElement("canvas");
    canvas.id="draw_board";
    canvas.className="navbar-fixed-top";
    canvas.height=WHeight
    canvas.width =WWidth;
    container_canvas.appendChild(canvas);
    c=document.getElementById("draw_board");

    ctx=c.getContext("2d");
}
function graphicObj(x,y,speed,r) {
    this.x=x;
    this.y=y;
    this.speed=speed;
    this.r=r;
}

graphicObj.prototype.draw = function() {

    // var grd=ctx.createLinearGradient(0,0,WWidth,WHeight);
    // grd.addColorStop(0,"black");
    // grd.addColorStop(1,"red");
    // ctx.strokeStyle= grd;
    // ctx.fillStyle=grd;
    ctx.fillStyle="white";
    ctx.shadowBlur=3;
    ctx.shadowColor="white";
    // ctx.clearRect(0,0,WWidth,WHeight)
    ctx.lineWidth=1;
    ctx.beginPath();
    ctx.arc(this.x+50,this.y+50,this.r,0,2*Math.PI)
    ctx.closePath();
    ctx.fill();
}


graphicObj.prototype.move=function (obj) {
    if (this.y<0){
        this.die();
        return;
    }

   this.y=this.y-this.speed;
    // this.x=this.x-Math.sin(Math.random()*3);
    this.draw();
}

graphicObj.prototype.die=function(){
        dot=this;
        dots.forEach(function (value, index, array) {
            if (dot==value){
                dots[index]=null;
                dots[index]=new graphicObj(Math.random()*WWidth,Math.random()*WHeight,Math.random()*2,Math.random()*3);
            }
        })

}
// var Obj = new graphicObj()
// Obj.x=500;
// Obj.y=500;
// Obj.draw(Obj.x,Obj.y);


dots.forEach(function (value,index,array) {
    value.draw();
})
var count=0;
function f() {
    ctx.clearRect(0,0,WWidth,WHeight);
    if (count<50){
        dots[count]=new graphicObj(Math.random()*WWidth,Math.random()*WHeight,Math.random()*2,Math.random()*3);
    }

    dots.forEach(function (value, index, array) {
        if (value==null)
        {
            return;
        }
        else {
            value.move(value);
        }

    })
    count++;
    requestAnimationFrame(f)
}
f();
// canvas.addEventListener(
// "mousemove",function (e) {
//     // if (ctx!=null)ctx.clearRect(0,0,1000,1000)
//     Obj.x=e.offsetX;
//     Obj.y=e.offsetY;
//     Obj.draw(Obj.x,Obj.y);
// })
