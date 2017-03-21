package factory.abstractfactory;

import factory.simplefactory.Benz;
import factory.simplefactory.Car;

public class BenzCarFactory extends CarFactory {
	@Override
	Car createCar(String car) throws Exception {
		return new Benz();
	}

}
