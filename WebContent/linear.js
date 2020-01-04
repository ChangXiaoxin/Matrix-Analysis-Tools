function calculate() {
	var x = document.getElementById("xinputs").value;
	var y = document.getElementById("yinputs").value;
	x=x.replace(' ','');
	y=y.replace(' ','');
	var arr=x.split(',');
	var arr2=y.split(',');
	if(arr.length!=arr2.length||arr.length==0){
		alert("请检查输入是否有错误");
		return ;
	}
	var lcm=0;
	var flag=false;
	var total=1;
	var x=0;
	var y=0;
	var xy=0;
	var xx=0;
	var yy=0;
	for(var j=0;j<arr.length;j++){
		arr[j]=parseFloat(arr[j]);
		arr2[j]=parseFloat(arr2[j]);
		x+=arr[j];
		y+=arr2[j];
		xx+=Math.pow(arr[j],2);
		yy+=Math.pow(arr2[j],2);
		xy+=arr[j]*arr2[j];
	}
	var xmean=x/arr.length;
	var ymean=y/arr.length;
	slope=(xy-arr.length*xmean*ymean)/(xx-arr.length*xmean*xmean);
	a=ymean-slope*xmean;
	slope=Math.round(slope*10000)/10000;
	a=Math.round(a*10000)/10000;
	y=a+' + '+slope+' x';
	document.getElementById("res_area").style.visibility = "visible";
	document.getElementById("result1").value = arr.length;
	document.getElementById("result2").value = slope;
	document.getElementById("result3").value = a;
	document.getElementById("result4").value = y;
	document.getElementById("result5").value = xmean;
	document.getElementById("result6").value = ymean;
}
