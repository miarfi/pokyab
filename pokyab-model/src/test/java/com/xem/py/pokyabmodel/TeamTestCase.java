/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xem.py.pokyabmodel;

import com.xem.py.pokyabmodel.dao.MatchDAO;
import com.xem.py.pokyabmodel.dao.TeamDAO;
import com.xem.py.pokyabmodel.dto.Match;
import com.xem.py.pokyabmodel.dto.Team;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author arria
 */
public class TeamTestCase {
    
    private static AnnotationConfigApplicationContext context;
    private static MatchDAO matchDAO;
    private static TeamDAO teamDAO;
    private Match match = null;    
    private List<Team> allTeams = null;
    private List<Team> allTeamsTmp = null;
        
    @BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.xem.py.pokyabmodel");
		context.refresh();
		
		matchDAO = (MatchDAO) context.getBean("matchDAO");
                teamDAO = (TeamDAO) context.getBean("teamDAO");
                                
	}
        
        
//        @Test 
//        public void addMatch(){
//            
//            allTeams =  teamDAO.getActiveTeams();
//            allTeamsTmp =  teamDAO.getActiveTeams();
//            int awayTeamId, localTeamId;
//            
//            System.err.println("allTeams "+allTeams.size()+"allTeams "+allTeamsTmp.size());                               
//            
//            for (int i = 0; (i < allTeams.size() && i<1); i++) {
//                awayTeamId = allTeams.get(i).getTeamId();
//                localTeamId = allTeamsTmp.get(i+1).getTeamId();
//                match = new Match();
//                match.setAwayTeamId(awayTeamId);
//                match.setHomeTeamId(localTeamId);
//                match.setWinnerTeamId(localTeamId);
//                match.setLeagueId(allTeams.get(i).getLeagueId());
//                match.setSeasonId(allTeams.get(i).getSeasonId());
//                match.setMatchDate(Date.from(Instant.now()));
////                match.setRefereePersonId(1);
//                match.setStatus("PLANNED");
//                matchDAO.add(match);
//            }
//
//           
//            assertEquals("Failed to add match!", true,  true);
//        }
}
