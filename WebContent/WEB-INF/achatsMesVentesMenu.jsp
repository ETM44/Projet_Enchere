<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>
	<div>
		<input type="radio" id="radioAchats" name="menuRadio" value="radioAchats" checked>
		<label for="radioAchats">Achats</label>
	</div>
	
	<div>
		<input type="radio" id="radioVentes" name="menuRadio" value="radioVentes">
		<label for="radioVentes">Mes ventes</label>
	</div>
</div>
<div>
	<div>
	  <input type="checkbox" id="enchOuv" name="enchOuv" checked>
	  <label for="enchOuv">ench�res ouvertes</label>
	</div> 
	<div>
	  <input type="checkbox" id="enchCour" name="enchCour">
	  <label for="enchCour">mes ench�res en cours</label>
	</div> 
	<div>  
	  <input type="checkbox" id="enchRemp" name="enchRemp">
	  <label for="enchRemp">mes ench�res remport�es</label>
	</div>
</div>
<div>
	<div>
	  <input type="checkbox" id="ventCour" name="ventCour" disabled>
	  <label for="ventCour">Mes ventes en cours</label>
	</div> 
	<div>
	  <input type="checkbox" id="ventDeb" name="ventDeb" disabled>
	  <label for="ventDeb">ventes non d�but�es</label>
	</div> 
	<div>  
	  <input type="checkbox" id="ventTer" name="ventTer" disabled>
	  <label for="ventTer">ventes termin�es</label>
	</div>
</div>

<script type="text/javascript">
	document.getElementById("radioAchats").onclick = function(){
		document.getElementById("enchOuv").disabled = false;
		document.getElementById("enchCour").disabled = false;
		document.getElementById("enchRemp").disabled = false;
		document.getElementById("ventCour").disabled = true;
		document.getElementById("ventDeb").disabled = true;
		document.getElementById("ventTer").disabled = true;
	}
	document.getElementById("radioVentes").onclick = function(){
		document.getElementById("enchOuv").disabled = true;
		document.getElementById("enchCour").disabled = true;
		document.getElementById("enchRemp").disabled = true;
		document.getElementById("ventCour").disabled = false;
		document.getElementById("ventDeb").disabled = false;
		document.getElementById("ventTer").disabled = false;
	}
</script>
