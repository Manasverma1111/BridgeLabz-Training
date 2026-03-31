package generics;
import java.util.ArrayList;
import java.util.List;

interface MealPlan {
    String getMealType();
    int getCalories();
}

class VegetarianMeal implements MealPlan {

    @Override
    public String getMealType() {
        return "Vegetarian";
    }

    @Override
    public int getCalories() {
        return 1800;
    }
}

class VeganMeal implements MealPlan {

    @Override
    public String getMealType() {
        return "Vegan";
    }

    @Override
    public int getCalories() {
        return 1600;
    }
}

class KetoMeal implements MealPlan {

    @Override
    public String getMealType() {
        return "Keto";
    }

    @Override
    public int getCalories() {
        return 2000;
    }
}

class HighProteinMeal implements MealPlan {

    @Override
    public String getMealType() {
        return "High Protein";
    }

    @Override
    public int getCalories() {
        return 2200;
    }
}

class Meal<T extends MealPlan> {

    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public T getMealPlan() {
        return mealPlan;
    }

    @Override
    public String toString() {
        return "MealPlan{" +
                "type='" + mealPlan.getMealType() + '\'' +
                ", calories=" + mealPlan.getCalories() +
                '}';
    }
}
class MealPlanGenerator {

    public static <T extends MealPlan> Meal<T> generateMealPlan(T mealPlan) {

        if (mealPlan.getCalories() <= 0) {
            throw new IllegalArgumentException("Invalid calorie count");
        }

        return new Meal<>(mealPlan);
    }
}

public class PersonalizedMealPlanGenerator {

    public static void main(String[] args) {

        Meal<VegetarianMeal> vegMeal = MealPlanGenerator.generateMealPlan(new VegetarianMeal());
        Meal<VeganMeal> veganMeal = MealPlanGenerator.generateMealPlan(new VeganMeal());
        Meal<KetoMeal> ketoMeal = MealPlanGenerator.generateMealPlan(new KetoMeal());
        Meal<HighProteinMeal> proteinMeal = MealPlanGenerator.generateMealPlan(new HighProteinMeal());

        List<Meal<? extends MealPlan>> meals = new ArrayList<>();
        meals.add(vegMeal);
        meals.add(veganMeal);
        meals.add(ketoMeal);
        meals.add(proteinMeal);

        meals.forEach(System.out::println);
    }
}

