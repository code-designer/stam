/**
 * 
 */
'use strict';

import { reload, toggleSubmenu } from "./fonctions.js";

const mediaQuery = window.matchMedia("(min-width:768px)");
window.onresize =  ()=>reload(mediaQuery);

if(!mediaQuery.matches) {
	const listItems = document.querySelectorAll('.menu-item');
	listItems.forEach(item => {
		item.addEventListener('click', ()=> toggleSubmenu(item));
	});
} 

console.log(!mediaQuery.matches);
console.error();