package edu.nyu.cs9053.homework9.jellybean;

public class ConsumerImplement implements Consumer {

	@Override
	public JellyBean consume(JellyBeanContainer from) {
		if (!from.isEmpty()) {
			return from.remove();
		} else {
			return null;
		} 
	}

}
