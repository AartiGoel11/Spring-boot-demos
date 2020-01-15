package in.tp.led.service;

@FunctionalInterface
public interface MaxFinder<T> {
	T max(T a,T b);
}
