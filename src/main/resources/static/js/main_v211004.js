var cart=[];//корзина
var ImgSrc;
	
/* добавляем в корзину */
function addToCart() {
	var id=$(this).attr('id_item');
	var qty=$('#qty').attr('value');
	var title=document.getElementById("title").innerHTML;
	var x=cart.length;
	if (cart.length){
	//console.log(title);
	
// проверка
	cartChk=JSON.parse (localStorage.getItem('cart'));
	
	var i;
	for (i in cartChk) {
	
	if (cartChk[i].item==id){
					cart[i].qty=qty;
					break;
	} else if (i==x-1) {cart[x]={"item":id,"qty":qty,"title":title};	
	} else {continue;}
	}
	}else {cart[x]={"item":id,"qty":qty,"title":title};}
	
	saveCart();
	loadCartLabel();

}

/* сохраняем корзину */
function saveCart(){
localStorage.setItem('cart', JSON.stringify(cart));
var cart_date=Date.parse(Date());
localStorage.setItem('cart_date', JSON.stringify(cart_date));
	var cartAddText=document.getElementsByClassName("add_button");
	//var cartAddText=cartAdd.getElementsByTagName("button");
	//console.log(cartAddText[0].innerHTML);
	cartAddText[0].innerHTML="ТОВАР ДОБАВЛЕН";
	cartAddText[0].style.color="#f10a0a";

}	

/* проверяем и загружаем корзину */
function loadCart() {
	
if (localStorage.getItem('cart')) {
cart=JSON.parse (localStorage.getItem('cart'));
dateCart();

} else {loadCartLabel();}	
}

/* проверка даты корзины  One day (24 hours) is 86 400 000 milliseconds */
function dateCart(){
var cart_date_current= Date.parse(Date());
cart_date_saved=JSON.parse (localStorage.getItem('cart_date'));
if (cart_date_current > cart_date_saved+2592000000){
deleteCart();	
//loadCartLabel();
} else {loadCartLabel();}
}

// удаляем корзину
function deleteCart(){
localStorage.removeItem('cart');
localStorage.removeItem('cart_date');
window.location.reload();	
}

/* проверка количества элементов в корзине и вывод на экран */
function loadCartLabel(){
	if(localStorage.getItem('cart')) {
	cart=JSON.parse (localStorage.getItem('cart')); 
		//if (cart.length){
		$('#cart-inner').html('<i>В корзине '+cart.length+' товар(а)</i>');
		}	
		else {$('#cart-inner').html('<i>Корзина пуста</i>');}	
		}

/* изменение и перечет кол-ва в поле со стрелками */
$(function(){
   $('.plus').click(function(e){
           e.preventDefault();
     var qwt = $(this).parents('.quantity:first').find('.qwt').val();
           qwt = ++qwt;  
           $(this).parents('.quantity:first').find('.qwt').val(qwt);
           $(this).parents('.quantity:first').find('.qwt2').val(qwt).trigger('change');
     
          recalcAmount(this);
          });
          $('.minus').click(function(e){
           e.preventDefault();
           var qwt = $(this).parents('.quantity:first').find('.qwt').val();
           qwt = --qwt;  
             if (qwt == 0){return false;
             } else {
             $(this).parents('.quantity:first').find('.qwt').val(qwt);
             $(this).parents('.quantity:first').find('.qwt2').val(qwt).trigger('change');  
              recalcAmount(this);  
             }
           });

});
             
             function recalcAmount(button, pricesEnabled) {
               var price = $(button).parents('.quantity:first').find('.qwt').attr('data-price');
               var qty = $(button).parents('.quantity:first').find('.qwt2').val();
               var total = price*qty;
               if ($('#order input[name="price_kinds"]').size() == 0) {
                 $('#total-price').html(total);
                 }
               
               //$(button).parents('tr:first').find('.total-price').html(InSales.formatMoney(total, cv_currency_format));
               //$(button).parents('tr:first').find('.qwt2').trigger('change');
             }

/* доп фото */

function galleryChanger () {
		var dataSRC=event.target.getAttribute('src');
		dataSRC=dataSRC.slice(0,-3);
		var parentDataSRC=event.target.parentNode;
		var childOfParentDataSRC=parentDataSRC.childNodes[1];
		
		var galleryImg=document.getElementById("addImgFromGallery");
		var ImgSrc=galleryImg.getAttribute('src');
		galleryImg.setAttribute("src",dataSRC+"jpg");
		
		galleryImg.style.border="3px solid red";
		setTimeout(function() {galleryImg.style.border="none"}, 500);
		//var aSrc=galleryImg.parentNode.parentNode;
		//aSrc.setAttribute("href",dataSRC+"jpg");
		
		var galleryWebp=document.getElementById("addIWebPFromGallery");
		var WebpSrc=galleryWebp.getAttribute('srcset');
		galleryWebp.setAttribute("srcset",dataSRC+"webp");
		
		event.target.setAttribute("src",ImgSrc);
		childOfParentDataSRC.setAttribute("srcset",WebpSrc);
}

/* ФИЛЬТР */

//function filter () {

//	var clearDIV=document.getElementsByClassName("prod-block");
//	var k;
//			for (k = 0; k < clearDIV.length; k++) {
//			clearDIV[k].style.display="inline-block";
//			clearDIV[k].className="prod-block notfiltered";
//				}
//				
//	var a=document.getElementById("filter").getElementsByTagName('h3');			
//	if (a.length>0) {
//		a[0].remove();
//	}
//	
//	var chkFil=document.getElementsByClassName("chkBoxFilter");
//	//var qtyFil=chkFil.length;
//	/*console.log(qtyFil); общее количество чек боксов */
//	
//		
//	var i;
//	for (i = 0; i < chkFil.length; i++) {
//	/*console.log(chkFil[i].childNodes[1].id); список названий чек боксов*/
//		if (chkFil[i].childNodes[1].checked)
//		{
//		//console.log(chkFil[i].childNodes[1].id+"Есть контакт"); /*если чек бокс активен, то печать его имени + есть контакт */
//		textBox=chkFil[i].childNodes[1].id;
//		/*console.log(textBox);*/
//		//console.log(chkFil[i].parentNode.id); /*вывод номер data*/
//		//n=chkFil[i].parentNode.id;
//		var idDIV=chkFil[i].parentNode.id;
//		/*console.log(idDIV);*/
//		
//		
//		//var qtyDIV=chkDIV.length;
//		//console.log(qtyDIV); /* вывод общего количеста item*/
//		
//		var nfDIV=document.getElementsByClassName("notfiltered");
//		//console.log(nfDIV.length);
//		if (nfDIV.length>0) {
//		/*console.log(chkDIV[1]);*/
//		/*console.log(chkDIV[1].getAttribute('data-3'));*/
//		
//				for (m = 0; m < clearDIV.length; m++) {
//					//console.log(m);
//					/*console.log(chkDIV[k].getAttribute('data-'+n));*/
//					textValue=clearDIV[m].getAttribute('data-'+idDIV);
//					/*console.log(textValue);*/
//					if (textBox!=textValue)
//					{
//					clearDIV[m].style.display="none";
//					clearDIV[m].className="prod-block filtered";
//					}
//				
//				}
//			}
//		}	
//	}
//	//var nfDIV=document.getElementsByClassName("notfiltered");
//	//console.log(nfDIV.length); /*вывод количества item после фильтра*/ 
//	
//	var filteredItems=document.createElement('h3');
//			
//			if (nfDIV.length==0) {
//			filteredItems.innerHTML="С заданными фильтрами результатов нет:<br>* Попробуйте уменьшить количество фильтров<br>* возможно нужного Вам товара нет на сайте - отправьте нам запрос на <a href=\"mailto:info@milkparts.ru\">info@milkparts.ru</a><br>* возможно заданы взаимоисключающие фильтры";	
//			} else {
//			filteredItems.innerHTML="С заданными фильтрами найден(о) "+nfDIV.length+" Товар(а)";	
//			}
//			document.getElementById("filter").prepend(filteredItems);		
//	
//}

function filterNew(){
	var u;
	var clearDIV=document.getElementsByClassName("prod-block"); // получаем кол-во единиц товара

			for (let k = 0; k < clearDIV.length; k++) { //устанавливаем для всех товаров НЕОТФИЛЬТРОВАНО
			clearDIV[k].style.display="inline-block";
			clearDIV[k].className="prod-block notfiltered";
				}
				
	var a=document.getElementById("filter").getElementsByTagName('h3');	//проверяем была-ли вставка результата фильтра до этого и если Да, то удаляем	
	if (a.length>0) {
		a[0].remove();
	}
	
	var chkBoxGroup=document.getElementsByClassName("chkBoxGroup"); //количество chkBoxGroup
	//console.log('количество chkBoxGroup '+chkBoxGroup.length);
	for (let r=0; r < chkBoxGroup.length; r++) {
		var checkboxNames=[];
		var chkBoxFilter=chkBoxGroup[r].getElementsByClassName("chkBoxFilter"); // получаем chkBoxFilter в каждом chkBoxGroup
		//console.log('количество chkBoxFilter в '+ (r+1)+' chkBoxGroup ='+ chkBoxFilter.length);
		for (let t=0; t < chkBoxFilter.length; t++) {
			if (chkBoxFilter[t].childNodes[1].checked) // если  чек бокс активен
				{ 
				checkboxNames.push(chkBoxFilter[t].childNodes[1].id); //добавляем его имя в массив
				}
		}		
		
		if (checkboxNames.length > 0) {
			
				var nfDIV=document.getElementsByClassName("notfiltered");
			//console.log('количество неотфильтрованных элементов '+nfDIV.length);
			//console.log('количество неотфильтрованных элементов '+clearDIV.length);
				for (let m = 0; m < nfDIV.length; m++) { //фильтруем каждый товар
					u=0;
					//console.log(m);
					textValue=nfDIV[m].getAttribute('data-'+(r+1));
					//console.log(textValue);
					checkboxNames.forEach(function(item){
						//console.log(item+ '  есть контакт');
						if (item===textValue) { u=1;
						//console.log(u);
						//console.log(item+ '  есть контакт');
						}
						
					});
					if (u!=1) {
						nfDIV[m].style.display="none";
						nfDIV[m].className="prod-block filtered";
						m=m-1;
					}
				}	
		}		
	}	
			
	
//		var nfDIV=document.getElementsByClassName("notfiltered"); // получаем все неотфильтрованные блоки
		//console.log(nfDIV.length);
		
		var filteredItems=document.createElement('h3');
			
			if (nfDIV.length==0) {
			filteredItems.innerHTML="С заданными фильтрами результатов нет:<br>* Попробуйте уменьшить количество фильтров<br>* возможно нужного Вам товара нет на сайте - отправьте нам запрос на <a href=\"mailto:info@milkparts.ru\">info@milkparts.ru</a><br>* возможно заданы взаимоисключающие фильтры";	
			} else {
			filteredItems.innerHTML="С заданными фильтрами найден(о) "+nfDIV.length+" Товар(а)";	
			}
			document.getElementById("filter").prepend(filteredItems);
}

/* Обнуление Фильтра */
function CleanFilter(){

var inputs = document.querySelectorAll('.chkBoxFilter');
  for (var i = 0; i < inputs.length; i++) {
    inputs[i].firstElementChild.checked = false;
	/*console.log(inputs[i]);*/
}
/*var DIVfiltred=document.getElementsByClassName("filtred");
	var k;
	for (k = 0; k < DIVfiltred.length; k++) {
		DIVfiltred[k].className="prod-block";	
	}*/
	
var chkDIV=document.getElementsByClassName("prod-block");
	var k;
	for (k = 0; k < chkDIV.length; k++) {
		chkDIV[k].style.display="inline-block";	
		chkDIV[k].className="prod-block notfiltered";
	}
	
var a=document.getElementById("filter").getElementsByTagName('h3');
if (a.length>0) {
		a[0].remove();
	}
}


$(document).ready(function(){
$('.add_button').on('click',addToCart);
loadCart();
$('.img_button').on('click',galleryChanger);
$('.filter_button').on('click',filterNew);
$('.CleanFilter_button').on('click',CleanFilter);
});