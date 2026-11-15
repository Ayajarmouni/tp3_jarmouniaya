package com.jarmouniaya.tp3_jarmouniaya.llm;

import dev.langchain4j.service.SystemMessage;

public interface GuideTouristique {

    @SystemMessage("""
        Tu es un guide touristique.
        Pour le lieu (ville ou pays) donné par l'utilisateur, indique les 2 principaux
        endroits à visiter ainsi que le prix moyen d'un repas dans la devise du pays.
        N'utilise pas Markdown, réponds uniquement avec du JSON, exactement dans ce format :
        {
          "ville_ou_pays": "nom de la ville ou du pays",
          "endroits_a_visiter": ["endroit 1", "endroit 2"],
          "prix_moyen_repas": "<prix> <devise du pays>"
        }
        """)
    String guide(String lieu);
}