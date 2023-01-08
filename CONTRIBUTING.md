# Contributing
Credit: [Neetcode Contributing](https://raw.githubusercontent.com/neetcode-gh/leetcode/main/CONTRIBUTING.md)
**Please read the [guidelines below](#contributing-guidelines) before opening a PR**

Currently Support:

* Java
* C#

Solutions are also welcome for any other *supported* language on leetcode.com!

[//]: # To contribute, please fork this repo and open a PR adding a [missing solution](./README.md#missing-solutions) from the supported languages.
To contribute, please fork this repo and open a PR adding a missing solution from the supported languages.

If you would like to have collaborator permissions on the repo to merge your own PRs or review others' PRs please let me know. 

## Contributing Guidelines

- **Match the casing of files and directories**
  - For files, it's **`<language>/<problem-number>-name-of-problem.<language-extension>`** (e.g. `csharp/0001-two-sum.cs`)
    - Make sure the `problem-number` is formatted as four digits adding leading zeroes if necessary
    - You can find the `name-of-problem` in the leetcode URL, e.g https://leetcode.com/problems/ _**two-sum**_ /
    - The exception to this case is Java. For Java, you have to name `java/_0001_two_sum.java` because if you start a Java file with a number, it won't show up in JUnit testing framework, and I have no idea why. This is a quickfix.
- **Give your PR a succinct and accurate title** (e.g. _"Create: 1-two-sum.cs"_)
- Prefer **one solution/change per PR** (not a hard and fast rule, but will typically make the review cycle shorter)
- **Follow the** [PR template](./.github/pull_request_template.md) and add additional information when needed
- **Make sure your code passes** submission on [leetcode.com](https://leetcode.com) for the problem it solves
- **Write clean code** (Your code should use semantically meaningful variable/method names, consistent style, etc) and easy to understand. for example, a single letter is probably not a semantically meaningful name
- **Ensure the problem is not already solved** in the language you're contributing in
- **INCLUDE SOME UNIT TESTS!!!**. I do know testing void methods and LinkedList, Tree will be hard to set up. If you can do it then feel free, but I won't be too strict on those. There is a file called LinkListTests.java which test a lots of Java Linked List solutions, take a look for inspiration.
- Include an explanation of your solution

## FAQs

**Q:** What should my solution include?

**A:** You can keep your solution exactly the same as the one you submit to leetcode, you don't need to write tests or your own implementation of leetcode's built-ins. Your submission should include:
1. The same one you submit to leetcode
2. Some Unit Tests. I am fully aware that it is consider bad practice to include the test in the same file. But for the purpose of this repo, please do it. Unit Tests will help you think of edge cases in a real interview environment
...For example, Java uses JUnit framework, and C# uses NUnit framework
3. Your code should compile in a IDE of your choice and can run and pass each tests. Currently, I know VSCode can run C# and Java Unit Tests, and Visual Studio Code can run C# Unit Tests.
4. An explanation walkthrough of how your code works. This can be helpful as you explain your solution in a real interview environment.
##

**Q:** What if the problem I want to add isn't in the Study Guide list or Missing Solutions table?

**A:** Questions outside of the Study Guide list can be added but please prioritise adding the listed solutions first.
##

<sub>Thanks for contributing</sub>