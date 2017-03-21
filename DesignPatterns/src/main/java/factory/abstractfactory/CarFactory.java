package factory.abstractfactory;

import factory.simplefactory.Car;

public abstract class CarFactory {
	abstract Car createCar(String car) throws Exception;
}
