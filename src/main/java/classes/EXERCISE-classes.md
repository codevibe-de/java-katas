# Exercise for "Java Class System"

**In this exercise, you will learn how inner types can help you simplify your code.**

Have a look at the `FridgeApp` and especially the `Fridge` class. It makes use of several other Java types.

Refactor the existing code so that only three top-level types remain. These remaining types should be

- `Fridge` since this is the type that will hold other inner types
- `FridgeApp` since this is our entry point
- `ListenerManagement` since this is some kind of external tool, which is used by the `Fridge` class

In other words, move these types (as inner types) into `Fridge`:

- `ListenerManagementAdapter`
- `SensorListener`
- `Thermostat`

Finally, take a look at your source code and clean up. Some parts might not be required anymore.