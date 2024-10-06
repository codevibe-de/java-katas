# Exercise Java Class System

Have a look at the `FridgeApp` and especially the `Fridge` class. It makes use of several other Java types.

Refactor the existing code so that only three top-level type remain. These remaining types should be

- `Fridge` since this is the type that will hold other inner types
- `FridgeApp` since this is our entry point
- `ListenerManagement` since this is some kind of external tool, which is used by the `Fridge` class