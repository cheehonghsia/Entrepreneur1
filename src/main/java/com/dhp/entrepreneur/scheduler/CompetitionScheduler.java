package com.dhp.entrepreneur.scheduler;

/**
 * @author Chee-Hong Hsia <br> 
* This is a Quartz job scheduled class that scans all existing TimeDrivenCompetitions and checks
* whether the start date equals the current date. If this is true, the Competition isActive flag will
* set to true.
 */
public interface CompetitionScheduler {
	
	/**
	 * Scan all Competitions and asses whether the start date is =< today. If this statement is true, the status 
	 * flag of the Competition will be set to ACTIVE.
	 */
	public void activateCompetition();
	
	/**
	 * Scan all Competitions and asses whether the end date is => today. If this statement is true, the status 
	 * flag of the Competition will be set to END.
	 */
	public void endCompetition();

}
