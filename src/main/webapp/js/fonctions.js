/**
 * 
 */
'use strict';
/**
 * {ListHTMLElement} element
 * {String} cssClass
 */
 
 export function toggleSubmenu(element){
	 const ul = element.querySelector('ul');
	 if(ul === null)
	 	return;
	 	
	 if(ul.classList.contains('submenu')){
		 ul.classList.remove('submenu');
	 	ul.classList.add('show-submenu');
	 } else {
		 ul.classList.add('submenu');
	 	ul.classList.remove('show-submenu');	
	 }
	 
 }
 
 
 export function reload(){
	 document.location.reload(true);
 }