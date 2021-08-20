<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>
	<div>
		<input type="radio" id="radioAchats" name="menuRadio" value="radioAchats" <c:if test="${accModel.lstRadio.get('radioAchats')}">checked</c:if>>
		<label for="radioAchats">Achats</label>
	</div>
	
	<div>
		<input type="radio" id="radioVentes" name="menuRadio" value="radioVentes" <c:if test="${accModel.lstRadio.get('radioVentes')}">checked</c:if>>
		<label for="radioVentes">Mes ventes</label>
	</div>
</div>
<div>
	<div>
	  <input type="checkbox" id="enchOuv" name="enchOuv" <c:if test="${accModel.lstCheckbox.get('enchOuv')}">checked</c:if>>
	  <label for="enchOuv">ench�res ouvertes</label>
	</div> 
	<div>
	  <input type="checkbox" id="enchCour" name="enchCour" <c:if test="${accModel.lstCheckbox.get('enchCour')}">checked</c:if>>
	  <label for="enchCour">mes ench�res en cours</label>
	</div> 
	<div>  
	  <input type="checkbox" id="enchRemp" name="enchRemp" <c:if test="${accModel.lstCheckbox.get('enchRemp')}">checked</c:if>>
	  <label for="enchRemp">mes ench�res remport�es</label>
	</div>
</div>
<div>
	<div>
	  <input type="checkbox" id="ventCour" name="ventCour" <c:if test="${accModel.lstCheckbox.get('ventCour')}">checked</c:if>>
	  <label for="ventCour">Mes ventes en cours</label>
	</div> 
	<div>
	  <input type="checkbox" id="ventDeb" name="ventDeb" <c:if test="${accModel.lstCheckbox.get('ventDeb')}">checked</c:if>>
	  <label for="ventDeb">ventes non d�but�es</label>
	</div> 
	<div>  
	  <input type="checkbox" id="ventTer" name="ventTer" <c:if test="${accModel.lstCheckbox.get('ventTer')}">checked</c:if>>
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
	if(document.getElementById("radioAchats").checked){
		document.getElementById("enchOuv").disabled = false;
		document.getElementById("enchCour").disabled = false;
		document.getElementById("enchRemp").disabled = false;
		document.getElementById("ventCour").disabled = true;
		document.getElementById("ventDeb").disabled = true;
		document.getElementById("ventTer").disabled = true;
	}
	if(document.getElementById("radioVentes").checked){
		document.getElementById("enchOuv").disabled = true;
		document.getElementById("enchCour").disabled = true;
		document.getElementById("enchRemp").disabled = true;
		document.getElementById("ventCour").disabled = false;
		document.getElementById("ventDeb").disabled = false;
		document.getElementById("ventTer").disabled = false;
	}
</script>
