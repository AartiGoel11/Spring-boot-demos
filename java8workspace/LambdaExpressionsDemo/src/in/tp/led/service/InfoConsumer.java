package in.tp.led.service;

@FunctionalInterface
public interface InfoConsumer {
	void repeat(String data,int occurs);
}