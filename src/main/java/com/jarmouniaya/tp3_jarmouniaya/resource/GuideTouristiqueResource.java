package com.jarmouniaya.tp3_jarmouniaya.resource;

import com.jarmouniaya.tp3_jarmouniaya.llm.LlmClientForGuideTouristique;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/guide")
@RequestScoped
public class GuideTouristiqueResource {

    @Inject
    private LlmClientForGuideTouristique llmClient;

    /**
     * Retourne les 2 principaux endroits à visiter et le prix moyen d'un repas
     * dans une ville ou un pays, au format JSON, grâce au LLM.
     *
     * @param villeOuPays nom de la ville ou du pays
     * @return réponse JSON du guide touristique
     */
    @GET
    @Path("lieu/{ville_ou_pays}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response endroitsDeVisite(@PathParam("ville_ou_pays") String villeOuPays) {
        String reponseJson = llmClient.guide(villeOuPays);
        return Response.ok(reponseJson).build();
    }
}