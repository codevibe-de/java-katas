# Exercise for the "Strategy" design pattern

Have a look at the `LetterApp` as well as the two classes `FormalLetter` and `InformalLetter`.

The class design is bad—we need to instantiate different letter types just to get a different greeting embedded into
our letter.

Make use of the Strategy design pattern to refactor the code so that we can change the greeting of a letter without
having to instantiate a new letter object.