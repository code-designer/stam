/**
 * 
 */
'use strict';
/**
 * {ListHTMLElement} element
 * {String} cssClass
 */
 
 export function toggleSubmenu(element, classA, classB){
	 const ul = element.querySelector('ul');
	 if(ul === null)
	 	return;
	 	
	 if(ul.classList.contains(classA)){
		ul.classList.remove(classA);
	 	ul.classList.add(classB);
	 } else {
		 ul.classList.remove(classB);
		 ul.classList.add(classA);	
	 }
 }
 
 
 /**
  * this reload the document
  *  */ 
 export function reload(){
	 document.location.reload(true);
 }
 
 /**
  * Set function to operate on a table
  */
 
 export function removeRows(table){
	 let ids = [];
	 const lines = table.querySelectorAll('tr.row td input:checked');
	 lines.forEach(line => {
		 let parent = line.parentElement.parentElement;
		 ids.push(parent.getAttribute('data-id'));
		 parent.remove();
	 });
	 console.log(ids);
 }