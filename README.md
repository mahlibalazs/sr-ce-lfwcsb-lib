## Match class
Since the Match class is primarily a simple record‑keeping POJO, I implemented it directly without applying a strict TDD workflow. For this kind of structure, it didn’t feel necessary to drive the implementation with tests first. I added tests afterward to validate correctness and document the expected behavior.
I also assumed that match scores should never be negative. Because this rule wasn’t explicitly stated in the requirements, I introduced the validation later and added a corresponding test case to enforce it.

Other assumptions:
* Assumed, that Match will not be used in other packages.
* Assumed, that the homeTeam and awayTeam Strings will never be null, empty or contain only whitespace and will fit into a String.
* Assumed, that the two teams will always be different, and the same two teams can not play another game in the same time/can not be on the scoreboard twice.

## Scoreboard class
For the scoreboard requirements, I first created a minimal Scoreboard stub and then wrote ScoreboardTest to define/verify the expected behavior of the future implementation. Since I followed a strict TDD workflow for this, no refactoring was needed afterwards.

### Summary function
Since matches are stored in insertion order, the list needed a reversal before sorting with a stable algorithm.

