package edu.nyu.cs9053.homework9.jellybean;

import java.util.Random;

public class ProducerImplement implements Producer {

	@Override
	public JellyBean produce(JellyBeanContainer into) {
		if (into.atCapacity()) {
			return null;
		}
		Random random = new Random();
        Flavor[] flavors = Flavor.values();
        JellyBean jellyBean = new JellyBean(flavors[random.nextInt(flavors.length)]);
        into.add(jellyBean);
		return jellyBean;
	}

}
