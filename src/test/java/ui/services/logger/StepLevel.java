package ui.services.logger;

import org.apache.log4j.Level;

/**
 * Class describes StepLevel of CustomLogger
 * 
 * @author Vyacheslav Milashov
 */
@SuppressWarnings("serial")
public class StepLevel extends Level {
	private static final int STEP_INT = INFO_INT + 10;

	public static final Level STEP = new StepLevel(STEP_INT, "STEP", 10);

	private StepLevel(int level, String levelStr, int syslogEquivalent) {
		super(level, levelStr, syslogEquivalent);
	}
}