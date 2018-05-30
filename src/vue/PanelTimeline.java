package vue;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import java.text.ParseException;
import modele.Agenda;
import modele.Date;
import modele.Evenement;


public class PanelTimeline extends JPanel
	{
	Controleur chControleur;
	Agenda leAgenda;
	public PanelTimeline() throws ParseException
		{
		leAgenda = new Agenda();
		leAgenda.ajout(new Evenement(new Date(5, 7, 1741), "Tourte", "Morrowind"));
		leAgenda.ajout(new Evenement(new Date(13, 4, 2009), "Terezi", "Skaia"));
		leAgenda.afficherContenu();
		}
	}