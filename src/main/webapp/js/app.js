/**
 * 
 */
'use strict';

import { reload, removeRows, toggleSubmenu } from "./dom.js";
//import * as functions from "./fonctions.js";

const lines = document.querySelectorAll('tr.row');

const mediaQuery = window.matchMedia("(min-width:768px)");
window.onresize =  ()=>reload(mediaQuery);

//add eventListener to each menu item for manage submenu
if(!mediaQuery.matches) {
	const listItems = document.querySelectorAll('.menu-item');
	listItems.forEach(item => {
		item.firstChild.addEventListener('click', ()=> toggleSubmenu(item, 'submenu','show-submenu'));
	});
	const sublistItems = document.querySelectorAll('.sub-menu-item');
	sublistItems.forEach(item2 => {
		item2.firstChild.addEventListener('click', ()=> toggleSubmenu(item2, 'submenu-2', 'show-submenu-2'));
	})
	
} 
//Add eventListener to checkbox for selection all lines
const inputChecker = document.querySelector('#check-all');
if(inputChecker !== null)
	inputChecker.addEventListener('click',()=>{
		lines.forEach(line => {
			line.firstElementChild
				.firstElementChild
				.checked = inputChecker.checked;
		});
	});

//Allow selection when clicking on a row table
if(lines !== null)
	lines.forEach(line =>{
		line.addEventListener('click',(e)=>{
			const checkbox = e.currentTarget
			.firstElementChild
			.firstElementChild;
			if(e.target.type !== 'checkbox')
				checkbox.checked = !checkbox.checked;
		});
	});

//For deleting row in table
const delBtn = document.querySelector('#delete-rows');
if(delBtn !== null)
	delBtn.addEventListener('click', (e)=>{
		e.preventDefault;
		const table = document.querySelector('.table-block table');
		removeRows(table);
	});

//Form - 
//Dispaly details informations according to selected value
const selectDemandeur = document.querySelector('#demandeur');
let personneMorale = document.querySelector('#personne-morale');
let personnePhysique = document.querySelector('#personne-physique');

if(selectDemandeur.value === 'personne'){
	personneMorale.style.display = 'none';
} else {
	personnePhysique.style.display = 'none';
}

if(selectDemandeur !== null){
	selectDemandeur.addEventListener('change',(e)=>{
		
		if(e.currentTarget.value === 'entreprise'){
			personneMorale.style.display = 'block';
			personnePhysique.style.display = 'none';
		} else {
			personneMorale.style.display = 'none';
			personnePhysique.style.display = 'block';
		}
	});
}
// Display or hide block
const detailsBlock = document.querySelectorAll('.form-act .rubriques');
detailsBlock.forEach(block => {
	let visible = true;
	block.addEventListener('click', ()=>{
		if(visible === true){
			block.nextElementSibling.style.display = 'none';
			visible = false;
		} else {
			block.nextElementSibling.style.display = 'block';
			visible = true;
		}
	})
});


console.error();