package fr.afcepf.al33.citron.panierSaisonWS.serveurSoap;

import javax.xml.ws.Endpoint;

import fr.afcepf.al33.citron.panierSaison.PanierSaisonImpl;

public class App 
{
	public App() {

		System.out.println("demarrage du serveurSoap ...");
		String URL = "http://localhost:8088/panierSaison/PanierSaison";
		PanierSaisonImpl implementor = new PanierSaisonImpl();
		System.out.println("URL WSDL="+URL+"?wsdl");
		Endpoint.publish(URL, implementor); //démarre un mini container web/http
		//intégré à la machine virtuelle java (ressemblant à Jetty)
	}
    public static void main( String[] args )
    {
    	new App();
		try {
			Thread.sleep(1000 * 60 * 15);// pause de 15 min
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Arret du Serveur");
		System.exit(0); // arret complet de tous les thread
    }
}
