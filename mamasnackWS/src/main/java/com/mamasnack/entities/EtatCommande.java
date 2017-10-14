package com.mamasnack.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape= JsonFormat.Shape.OBJECT)
public enum EtatCommande {
	
	Initiale,
	Preparation_Encours,
	Paiement_Accepte,
	Paiement_EnAttente,
	Livre,
	NonLivre,
	Dispoible,
	Annule,
	Remborse;
	
	  @Override
      public String toString() {
          return this.name().toLowerCase();
      }
	
	

}
