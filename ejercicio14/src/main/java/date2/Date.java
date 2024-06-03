package date2;

import java.time.LocalDate;

public interface Date {
	public LocalDate getTo();
	public LocalDate getFrom();
	public int sizeInDays();
	public boolean includesDate(LocalDate other);
}
