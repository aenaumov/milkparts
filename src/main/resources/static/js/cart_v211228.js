
var x;
function loadCart() {
	
if (localStorage.getItem('cart')) {
	cart=JSON.parse (localStorage.getItem('cart'));
	var table=document.getElementById("cart_table");
	var content=document.getElementById("content");

// вывод в таблицу
	
	var i;
	
	for (i in cart) {
		
		// строка корзины
		var row_descr=document.createElement('tr');
		row_descr.style.position="relative";
		cart_table.appendChild(row_descr);
		
			// колонка наименование
			var column_title=document.createElement('td');
			column_title.innerHTML=cart[i].title;
			column_title.style.align="center";
			column_title.setAttribute("colspan", "2");
			column_title.setAttribute("class", "column_title");
			//column_title.style.width="350px";
			row_descr.appendChild(column_title);
			
			//var column=document.createElement('td');
			//row_descr.appendChild(column);			
			
			
	
		// строка корзины
		var row=document.createElement('tr');
		row.style.position="relative";
		cart_table.appendChild(row);
			
			//колонка картинка
			var column_img=document.createElement('td');
			column_img.setAttribute("class", "column_img");
			row.appendChild(column_img);
			var img=document.createElement('img');
			img.setAttribute("src","https://www.milkparts.ru/img/item/compact_"+cart[i].item+".jpg");
			column_img.appendChild(img);			
			

			
			// колонка количество
			var column_qty=document.createElement('td');
			column_qty.setAttribute("class", "column_qty");
			//column_qty.style.width="200px";
			var qty=document.createElement('p');
			qty.id=i;
			qty.innerHTML=cart[i].qty+" шт";
			//qty.style.margin="10px";
			//qty.style.display="inline";
			row.appendChild(column_qty);
			column_qty.appendChild(qty);
			
		/*	// кнопка редактировать
			var link_change=document.createElement('a');
			link_change.innerHTML="ИЗМЕНИТЬ";
			link_change.href="item.php?item="+cart[i].item;
			column_qty.appendChild(link_change);
		*/	
			
			// кнопка минус
			var button_minus=document.createElement('button');
			button_minus.innerHTML="-";
			button_minus.setAttribute("class", "buy_button minus_button");
			button_minus.setAttribute("value",i);
			//button_minus.style.margin="5px";
			column_qty.appendChild(button_minus);
			
		/*
			// ввод количества
			var quantity=document.createElement('input');
			quantity.value=cart[i].qty;
			quantity.type="text";
			quantity.disabled="disabled";
			quantity.style.display="inline";
			quantity.setAttribute("class","quantity_input qwt");
			column_qty.appendChild(quantity);
		*/	
			//кнопка плюс
			var button_plus=document.createElement('button');
			button_plus.innerHTML="+";
			button_plus.setAttribute("class", "buy_button plus_button");
			button_plus.setAttribute("value",i);
			//button_plus.style.margin="5px";
			column_qty.appendChild(button_plus);
		
			//кнопка удалить отдельную позицию
			var button_delete=document.createElement('button');
			button_delete.innerHTML="X";
			button_delete.setAttribute("class", "buy_button delete_item_button");
			button_delete.setAttribute("value",i);
			column_qty.appendChild(button_delete);


			
	}
// конец вывода в таблицу	

var sendButton=document.createElement('button');
			  sendButton.innerHTML="ОТПРАВИТЬ";
			  sendButton.setAttribute("class","buy_button send_button");
			  //sendButton.style.margin="10px";
			  content.appendChild(sendButton);
			  
var deleteButton=document.createElement('button');
			  deleteButton.innerHTML="ОЧИСТИТЬ КОРЗИНУ";
			  deleteButton.setAttribute("class","buy_button delete_button");
			  deleteButton.style.color="red";
			  deleteButton.style.background="white";
			  content.appendChild(deleteButton);
	
	// пустая корзина
}	else {$('#content').html('<h1>В Вашей корзине пусто</h1>');
		var img_cart_empty=document.createElement('img');
			img_cart_empty.setAttribute("src","assets/cart_empty.svg");
			img_cart_empty.setAttribute("class","big-image");
			img_cart_empty.style.height = "250px";
			document.getElementById("content").appendChild(img_cart_empty);
}


} 

// удаляем корзину
function deleteCart(){
	localStorage.removeItem('cart');
	localStorage.removeItem('cart_date');
	loadCart();	
}	

// удаляем отдельную позицию из корзины
function deleteCartItem(){
	x=cart.length;
	if (x>1){
	var id=$(this).attr('value');
	cart.splice(id,1);
	saveCart();
	} else {deleteCart();}
	window.location.reload();	
}

/* увеличение количества отдельной позиции в корзине */
function plusItemQty(){
	var id=$(this).attr('value');
	cart[id].qty++;
	saveCart();
	document.getElementById(id).innerHTML=cart[id].qty+" шт";	
}

/* уменьшение количества отдельной позиции в корзине */
function minusItemQty(){
	var id=$(this).attr('value');
	cart[id].qty--;
	if (cart[id].qty<1){
		x=cart.length;
		if (x>1){
		cart.splice(id,1);
		saveCart();
		} else {deleteCart();}
		window.location.reload();	
	} else {
	saveCart();
	document.getElementById(id).innerHTML=cart[id].qty+" шт";
	}	
}

/* сохраняем корзину */
function saveCart(){
localStorage.setItem('cart', JSON.stringify(cart));
var cart_date=Date.parse(Date());
localStorage.setItem('cart_date', JSON.stringify(cart_date));	
}

function sendCart(){
document.location.href='cartsend';
}		
			
$(document).ready(function(){
loadCart();	
$('.delete_button').on('click',deleteCart);
$('.delete_item_button').on('click',deleteCartItem);
$('.send_button').on('click',sendCart);
$('.plus_button').on('click',plusItemQty);
$('.minus_button').on('click',minusItemQty);
});