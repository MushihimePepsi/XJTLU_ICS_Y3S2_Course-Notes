- [1.  评估](#1--评估)
  - [1.1 HCI的评估方法和标准](#11-hci的评估方法和标准)
  - [1.2 评估方法的类型](#12-评估方法的类型)
  - [1.3 评估遇到的实际挑战](#13-评估遇到的实际挑战)
  - [1.4 可用性测试（Usability testing）](#14-可用性测试usability-testing)
    - [1.4.1 定量指标](#141-定量指标)
    - [1.4.2 可用性测试的条件和要求](#142-可用性测试的条件和要求)
    - [1.4.3 计算机系统可用性问卷（Computer System Usability Questionnaire，CSUQ）](#143-计算机系统可用性问卷computer-system-usability-questionnairecsuq)
    - [1.4.4 系统可用性评分（System Usability Score， SUS）](#144-系统可用性评分system-usability-score-sus)
    - [1.4.5 其他工具](#145-其他工具)
    - [1.4.6 可用性测试和实验的关系](#146-可用性测试和实验的关系)
  - [1.5 实验设计（Experimental design）](#15-实验设计experimental-design)
    - [1.5.1 研究假设（Research Hypotheses）](#151-研究假设research-hypotheses)
    - [1.5.2 实验设计方法](#152-实验设计方法)
      - [1.5.2.1 两种方法的对比](#1521-两种方法的对比)
    - [1.5.3 实验设计的过程](#153-实验设计的过程)
      - [1.5.3.1 数据收集阶段的过程](#1531-数据收集阶段的过程)
  - [1.6 数据分析](#16-数据分析)

# 1.  评估
评估的目的是为了检查用户的需求，确保用户能够使用产品，并且喜欢这个产品。
评估的内容包括以下几方面：
1. 概念模型（Conceptual Model）。
2. 早期和后续原型（Early and Subsequent Prototypes）。
3. 更完整的原型（More Complete Prototypes）。
4. 与竞争对手产品的对比原型（Prototype to Compare with Competitors’ Products）。

评估可以在以下几种环境中进行：
1. 自然环境（Natural Settings）
2. 真实环境（In-the-Wild Settings）
3. 实验室环境（Laboratory Settings）

后续我们还会详细讨论。

评估应该贯穿整个设计过程，从产品设计的早期阶段开始，就应该进行评估。我们还需要对成品进行评估。即使产品已经完成并推向市场，评估仍然很重要。通过评估成品，可以收集用户反馈，了解产品的实际表现，从而为下一代产品的设计提供信息。

## 1.1 HCI的评估方法和标准
在早期的HCI研究中，测量指标主要集中在人类的表现上，尤其是任务完成情况。
主要关注以下几个方面：
1. 时间表现（Time Performance）。
2. 任务正确性/准确性（Task Correctness / Accuracy）。
3. 错误率（Error Rate）。
4. 学习时间和记忆保持（Time to Learn and Retention Over Time）。
5. 用户满意度（User Satisfaction）。

微观HCI主要关注用户与系统交互的具体任务和操作层面。它侧重于评估用户在完成特定任务时的表现和体验。其包含：
1. 时间表现（Time Performance）。
2. 任务正确性/准确性（Task Correctness / Accuracy）。
3. 错误率（Error Rate）。
4. 学习时间和记忆保持（Time to Learn and Retention Over Time）。
5. 用户满意度（User Satisfaction）。
 
宏观HCI则关注用户与系统交互的更广泛的社会和情感层面。它侧重于评估用户在使用系统时的整体体验，包括动机、协作、社会参与、信任和同理心等方面。其包含：
1. 动机（Motivation）。
2. 协作（Collaboration）。
3. 社会参与（Social Participation）。
4. 信任（Trust）。
5. 同理心（Empathy）。 

## 1.2 评估方法的类型
评估方法主要分为三种：
1. 直接涉及用户的受控环境：在受控的环境中进行评估，这些环境通常是由研究人员或设计师精心设计和管理的，以确保评估过程的标准化和可重复性。
例如：可用性实验室和研究性实验室。
这种评估方法的优点是可以精确地控制变量，例如用户使用的设备、任务的难度、环境的干扰等，从而能够更准确地评估产品的性能和用户体验。
2. 涉及用户的自然环境：在用户实际使用产品或系统的自然环境中进行评估，这些环境通常是用户日常生活的场景，没有或很少有外部控制。
例如：在线社区和公共场所。
在这种环境中，用户的行为更加自然，但研究人员对用户行为的控制程度较低。尤其是在“野外”（in-the-wild）环境中，用户可能会以完全不同的方式使用产品，甚至可能会出现研究人员未曾预料到的情况。但是由于缺乏控制，这种评估方法可能会受到外部因素的干扰，但它的优势在于能够提供真实世界中用户行为的洞察。
3. 不直接涉及用户的任何环境：在不直接涉及用户的情况下进行评估，通常由专家或研究人员对产品或系统进行审查和分析。
例如：专门的顾问和研究人员对产品原型进行进行批评（critique）。他们可能会基于自己的专业知识和经验，预测并建模产品在用户使用时的成功程度。
这种方法不依赖于用户的直接反馈，而是依赖于专家的判断和分析。专家可能会使用各种工具和模型来评估产品的设计、功能和潜在的用户体验。它可以在产品开发的早期阶段快速识别问题，节省时间和成本，但缺点是缺乏用户的真实反馈，可能会导致评估结果与实际情况存在偏差。

下图对几种评估方式的差异进行了比较。
![在这里插入图片描述](https://i-blog.csdnimg.cn/direct/4e2520954aac4d7fbf6064652fa1bb50.png)

下图展示了这三种类型对应的具体测试方法。
![在这里插入图片描述](https://i-blog.csdnimg.cn/direct/b9aae292b56e463ba76b3e1cdfd4dbef.png)
有的我们已经学过，有的我们将在之后学习。

## 1.3 评估遇到的实际挑战
进行评估或研究时，需要获取参与者的同意。
1. 告知参与者：
参与者需要被告知评估的目的（why the evaluation is being done），他们将被要求做什么（what they will be asked to do），以及他们的权利（informed about their rights）。
研究者有责任确保参与者了解他们参与研究的具体情况，包括研究的目的、过程、可能的风险和好处，以及他们有权随时退出研究。
2. 知情同意书（Informed consent forms）：
知情同意书提供了上述信息，并作为参与者和研究者之间的合同（act as a contract between participants and researchers）。
这些表格通常包括研究的详细信息、参与者的权利和义务，以及他们同意参与研究的签名。
3. 高权威机构的批准：
知情同意书的设计、评估过程、数据分析方法和数据存储方法通常需要得到高权威机构的批准（approved by a high authority）。
这些机构负责确保研究的伦理性和合法性，保护参与者的权益。
例如：我们学校的University Ethics Committee (UEC，大学伦理委员会)

我们的实验数据需要注意以下几点。
1. Reliability（可靠性）：
指的是使用同一方法在不同时间或不同情境下是否能得到一致的结果。高可靠性意味着结果的稳定性和一致性。
2. Validity（效度）：
指的是评估方法是否真正测量了它打算测量的东西。效度分为几种类型，包括内容效度、结构效度和表面效度等，确保评估工具或方法能够准确反映被测量的概念或特质。
3. Ecological validity（生态效度）：
指的是评估环境是否真实反映了参与者的自然行为环境。高生态效度意味着评估结果在自然环境中同样适用，环境因素不会对结果产生扭曲。
4. Biases（偏差）：
指的是可能影响结果准确性的各种系统性误差。偏差可能来源于样本选择、测量工具、评估者或参与者的行为等。识别和控制偏差对于确保结果的准确性和公正性至关重要。
5. Scope（范围）：
指的是评估结果的普遍适用性或推广性。范围涉及结果是否可以推广到更广泛的人群或情境中。高范围意味着结果不仅适用于特定的样本或环境，还可以推广到其他相似的情况。

## 1.4 可用性测试（Usability testing）
Controlled settings（受控环境）：可用性测试通常在受控环境中进行，如实验室或专门的测试室。这有助于控制变量，减少外部干扰，从而更准确地评估产品的易用性。
Users are observed and timed（观察并计时用户）：在测试过程中，用户的操作会被观察并计时。这有助于评估用户完成任务所需的时间，以及他们在操作过程中的效率。
Data is recorded on video, and key presses are logged（录制视频并记录按键）：用户的操作过程会被录像，同时记录他们的按键操作。这些数据可以用来分析用户的行为，识别问题和错误。
The data is used to calculate performance times and to identify and explain errors（利用数据计算性能时间并识别和解释错误）：
收集的数据被用来计算用户完成任务所需的时间，并识别和解释用户在操作过程中遇到的错误。这有助于了解产品的易用性问题。
User satisfaction is evaluated using questionnaires and interviews（通过问卷和访谈评估用户满意度）：
在测试结束后，通常会使用问卷和访谈来评估用户的满意度。这有助于了解用户对产品的整体感受和满意度。
Field observations may be used to provide contextual understanding（现场观察可能用于提供背景理解）：
现场观察可以帮助研究人员更好地理解用户在自然环境中如何使用产品，以及他们在使用过程中遇到的上下文问题。
Involves recording performance of typical users doing typical tasks（涉及记录典型用户执行典型任务的表现）：
可用性测试通常涉及记录典型用户在执行典型任务时的表现。这有助于评估产品在实际使用中的易用性。

### 1.4.1 定量指标
我们可以使用一些定量指标（Quantitative performance measures）去衡量用户在使用产品或服务的表现，帮助研究人员和设计者了解产品的易用性和效率。
1. Number of users successfully completing the task（成功完成任务的用户数量）。
2. Time to complete task（完成任务所需的时间）。
3. Time to complete task after time away from task（离开任务后返回完成任务所需的时间）。
4. Number and type of errors per task（每个任务的错误数量和类型）。
5. Number of errors per unit of time（单位时间内的错误数量）。
6. Number of navigations to online help or manuals（导航到在线帮助或手册的次数）。
7. Number of users making a particular type of error（犯特定类型错误的用户数量）。

然后对上面的数据进行计数和计算，以获得具体的数值结果，这些结果可以用于进一步的分析和比较。

### 1.4.2 可用性测试的条件和要求
1. Usability lab or other controlled space（可用性实验室或其他受控空间）：
测试通常在专门的可用性实验室或其他受控环境中进行，以确保测试条件的一致性和可控性。
2. Selecting representative users（选择代表性用户）：
选择能够代表目标用户群体的参与者，以确保测试结果的普遍适用性和准确性。
3. Developing representative tasks（开发代表性任务）：
设计能够反映用户在实际使用中会遇到的任务，以评估产品在真实使用场景中的表现。
4. 5-10 users typically selected（通常选择5-10名用户）：
根据研究经验，5-10名用户通常足以发现大部分显著的可用性问题。
5. Tasks usually around 30 minutes（任务通常持续约30分钟）：
每个任务的持续时间通常在30分钟左右，以确保用户能够集中注意力，同时避免疲劳。
6. Test conditions are the same for every participant（每个参与者的测试条件相同）：
确保所有参与者在相同的条件下进行测试，以保证测试结果的可比性和可靠性。
7. Informed consent form explains procedures and deals with ethical issues（知情同意书解释程序并处理伦理问题）：
在测试开始前，参与者需要签署知情同意书，该同意书详细解释了测试的程序、目的、可能的风险和好处，以及参与者的权利和义务。
知情同意书还涉及伦理问题，如数据的保密性和参与者的隐私保护，确保测试过程符合伦理标准。

我们在这里虽然说通常5-10人即可，但是测试的时间安排可能会影响可以参与测试的人数。例如如果时间有限，可能只能安排较少的参与者。
而且目标用户群体的可用性也会影响参与者的数量。如果难以找到足够的目标用户，可能需要扩大招募范围。
测试的成本，包括支付给参与者的报酬、测试设施的使用费用、研究人员的工资等，都是需要考虑的因素。成本限制可能会影响可以招募的参与者数量。
一些专家建议，测试应该持续进行，直到没有新的见解或问题被发现。这种方法被称为“渐进式”或“迭代式”测试，它可以根据测试过程中的发现动态调整测试计划。例如我们采访了很多人，后面一部分的受访者没有新的见解或想法。

### 1.4.3 计算机系统可用性问卷（Computer System Usability Questionnaire，CSUQ）
比如使用CSUQ来进行可用性测试。
它是一种评估计算机系统用户满意度和可用性的工具。它包含了一系列问题，没问题每个问题都有一个7点量表（从“非常不同意”到“非常同意”），用户需要根据自己的使用体验进行评分。
1. Overall, I am satisfied with how easy it is to use this system：
我对这个系统的易用性总体上感到满意。
2. It was simple to use this system：
这个系统使用起来很简单。
3. I can effectively complete my work using this system：
我可以使用这个系统有效地完成我的工作。
4. I am able to complete my work quickly using this system：
我能够使用这个系统快速完成我的工作。
5. I am able to efficiently complete my work using this system：
我能够使用这个系统高效地完成我的工作。
6. I feel comfortable using this system：
使用这个系统我感到舒适。
7. It was easy to learn to use this system：
学习使用这个系统很容易。
8. I believe I became productive quickly using this system：
我相信我在使用这个系统后很快就变得高效了。
9. The system gives error messages that clearly tell me how to fix problems：
系统提供的错误信息清楚地告诉我如何解决问题。
10. Whenever I make a mistake using the system, I recover easily and quickly：
每当我使用系统时出错，我都能容易且迅速地恢复。
11. The information (such as online help, on-screen messages, and other documentation) provided with this system is clear：
系统提供的信息（如在线帮助、屏幕消息和其他文档）是清晰的。
12. It is easy to find the information I needed：
很容易找到我需要的信息。
13. The information provided for the system is easy to understand：
系统提供的信息易于理解。
14. The information is effective in helping me complete the tasks and scenarios：
这些信息在帮助我完成任务和场景方面是有效的。
15. The organization of information on the system screens is clear：
系统屏幕上的信息组织清晰。
16. The interface of this system is pleasant：
这个系统的界面令人愉快。
17. I like using the interface of this system：
我喜欢使用这个系统的界面。
18. This system has all the functions and capabilities I expect it to have：
这个系统拥有我所期望的所有功能和能力。
19. Overall, I am satisfied with this system：
总体而言，我对这个系统感到满意。

### 1.4.4 系统可用性评分（System Usability Score， SUS）
SUS也是一种评估用户对产品或系统可用性的标准化方法。
SUS将用户的响应转换为数字，其中“非常不同意”对应数字1，“非常同意”对应数字5。
对于奇数编号的问题（例如，问题1、3、5等），从用户的回答中减去1。这是因为奇数问题的设计是正向的，即高分表示正面反馈。
对于偶数编号的问题（例如，问题2、4、6等），从5中减去用户的回答。这是因为偶数问题的设计是反向的，即高分表示负面反馈。
将所有问题调整后的分数相加，然后将总分乘以2.5。这个计算方法将原始分数转换为一个0到100之间的分数。将最终的分数呈现为 SUS 分数。

一个 SUS 分数高于68被认为是高于平均水平，而低于68则被认为是低于平均水平。这个阈值是基于大量研究和数据分析得出的。
为了更准确地解释结果，建议将分数“正常化”以产生百分位排名。这意味着将你的 SUS 分数与一个参考数据库中的分数进行比较，以确定你的分数在所有已知分数中的位置。这有助于理解你的产品的可用性相对于其他产品或系统的表现。

问卷细节如下：
1. I think that I would like to use this system frequently.：
我认为我会喜欢经常使用这个系统。（正向问题）
2. I found the system unnecessarily complex.：
我发现这个系统不必要地复杂。（反向问题）
3. I thought the system was easy to use.：
我认为这个系统很容易使用。（正向问题）
4. I think that I would need the support of a technical person to be able to use this system.：
我认为我需要技术人员的支持才能使用这个系统。（反向问题）
5. I found the various functions in this system were well integrated.：
我发现这个系统中的各个功能整合得很好。（正向问题）
6. I thought there was too much inconsistency in this system.：
我认为这个系统有太多的不一致性。（反向问题）
7. I would imagine that most people would learn to use this system very quickly.：
我会想象大多数人能很快学会使用这个系统。（正向问题）
8. I found the system very cumbersome to use.：
我发现这个系统使用起来非常笨重。（反向问题）
9. I felt very confident using the system.：
使用这个系统我感到非常自信。（正向问题）
10. I needed to learn a lot of things before I could get going with this system.：
在我开始使用这个系统之前，我需要学习很多东西。（反向问题）

### 1.4.5 其他工具
还有一些其他成熟的、广泛使用的问卷调差工具。
1.Questionnaire for User Interface Satisfaction (QUIS)。
一种用于评估用户对用户界面满意度的问卷。它旨在衡量用户对界面设计的主观评价，包括界面的易用性、视觉吸引力和整体满意度。

2.Software Usability Measurement Inventory (SUMI)。
一种用于评估软件可用性的问卷。它通过用户对软件特定方面的评价来衡量软件的可用性，包括易用性、效率、控制感和满意度。

3.Visual Aesthetics of Website Inventory (VisAwi)。
一种专注于评估网站视觉美学的问卷。它通过用户对网站视觉设计的评价来衡量网站的吸引力，包括颜色、布局、字体和图像等视觉元素。

4.NASA Task Load Index (NASA TLX)。
一种用于评估任务负载的多维度问卷。它通过六个维度（包括心理需求、身体需求、时间压力、绩效、努力程度和挫折感）来衡量用户在执行任务时的负载感受。

### 1.4.6 可用性测试和实验的关系
首先可用性测试是应用实验。
开发者通过收集参与者在规定任务上的表现数据来检查系统是否适用于目标用户群体。
实验通过调查两个或更多变量之间的关系来测试假设并发现新知识。
例如，在可用性测试中，研究者可能会改变用户界面的设计元素（自变量），然后观察这些变化如何影响用户完成任务的速度和准确性（因变量）。

下面是更详细的对比。
可用性测试：
1. 改进产品：可用性测试的主要目的是通过发现和解决用户在使用产品时遇到的问题来改进产品。
2. 少量参与者：可用性测试通常只需要少量的参与者（例如5-10人），因为测试的目标是发现显著的可用性问题，而不是进行统计分析。
3. 结果指导设计：可用性测试的结果直接用于指导产品的设计和改进，帮助开发者了解用户的需求和问题。
4. 通常不能完全复制：由于可用性测试的条件（如参与者、任务等）可能因测试而异，因此结果可能不完全可复制。
5. 尽可能控制条件：尽管可用性测试的条件可能因测试而异，但仍然会尽可能控制变量，以减少外部干扰。
6. 计划好的程序：可用性测试通常有详细的计划和程序，包括任务、问题和评估方法。
7. 结果报告给开发者：可用性测试的结果直接报告给产品开发者，以便他们根据反馈进行设计改进。

研究实验：
1. 发现知识：研究实验的主要目的是通过测试假设来发现新知识，而不仅仅是改进产品。
2. 大量参与者：研究实验通常需要大量的参与者，以便进行统计分析，验证结果的显著性。
3. 结果通过统计验证：研究实验的结果需要通过统计方法进行验证，以确保发现是可靠的。
4. 必须可复制：研究实验的结果必须是可复制的，即其他研究者在相同条件下应该能够获得相同的结果。
5. 严格控制条件：研究实验的条件必须严格控制，以确保结果的可靠性和可复制性。
6. 实验设计：研究实验需要精心设计的实验方案，包括自变量、因变量、控制变量等。
7. 向科学界报告：研究实验的结果需要以科学报告的形式向科学界公布，以便其他研究者进行评估和验证。

## 1.5 实验设计（Experimental design）
我们前面将实验与可用性测试进行了对比，现在我们正式介绍实验设计。
实验的主要目的是检验研究者提出的假设（hypothesis），即对某个现象的解释或预测。假设通常基于理论或先前的研究，需要通过实验来验证其正确性。
实验是要预测两个或多个变量之间的关系。而这里的自变量由研究者操控，因变量受自变量影响。典型的实验设计有一个或两个自变量。
实验结果可以通过统计验证并且可复制。

### 1.5.1 研究假设（Research Hypotheses）
实验通常以研究假设开始，而假设是一个可以通过实证调查直接测试的精确问题陈述。
假设通常采用"如果...那么..."的形式，例如："如果我改变自变量X，那么因变量Y也会随之改变。"这种形式的陈述使得假设可以直接通过实验来测试。

我们将假设分为两种：
1. H0:Null hypothesis（零假设）：
零假设通常表示实验处理之间没有差异，或者说，自变量对因变量没有影响。它是一种保守的假设，假设现状或现有理论是正确的，除非有充分的证据证明否则。
例如，如果研究一种新药的效果，零假设可能是“新药与安慰剂在治疗效果上没有差异”。
2. H1:Alternative hypothesis（备择假设）：
备择假设是与零假设相互排斥的陈述，表示自变量对因变量有影响，或者说实验处理之间存在差异。它反映了研究者想要证明的效应或关系。
继续上面的例子，备择假设可能是“新药比安慰剂有更好的治疗效果”。

实验的目标是找到统计证据来拒绝零假设，以支持备择假设。或者说是为了确定一个或多个自变量（独立变量）是否对因变量（依赖变量）产生影响，以及这种影响的性质和大小。
我们可以以下图的方式记住这个知识点。拒绝零假设就是接受的意思。
![在这里插入图片描述](https://i-blog.csdnimg.cn/direct/0614bb88b400434f81ee1fdca3a4d310.png)

### 1.5.2 实验设计方法
实验设计方法分为两种：
1. 被试间设计（Between subjects design）
在这种设计中，不同的参与者被随机分配到不同的实验条件或组别中。每个参与者只参与一个实验条件。
参与者被随机分配到不同的实验组，这样做可以减少实验结果受到参与者特定特征影响的偏差，提高实验的内部效度。
2. 被试内设计（Within subjects design）
在这种设计中，同一组参与者会经历所有的实验条件。这意味着每个参与者都会在不同的时间点或顺序下接受所有的实验处理。
由于所有参与者都经历了实验的所有条件，因此可以减少个体差异对实验结果的影响，因为这些差异在比较不同条件时会被“抵消”。
![在这里插入图片描述](https://i-blog.csdnimg.cn/direct/93f285286f2d4b92826bd95ecf102158.png)
#### 1.5.2.1 两种方法的对比
被试间设计（Between subjects design）：
优点：No order effects（无顺序效应）：
在被试间设计中，不同的参与者被分配到不同的实验条件，因此不存在由于实验条件呈现顺序导致的顺序效应。每个参与者只经历一个条件，所以他们对条件的体验不会受到之前条件的影响。
缺点：Many subjects（需要较多参与者）：
由于每个参与者只经历一个实验条件，因此需要更多的参与者来确保每个条件都有足够数量的样本。
Individual differences is a problem（个体差异是个问题）：
参与者之间的个体差异可能会影响实验结果，因为每个参与者的背景、能力和其他特征都可能不同。
Within-subjects design（被试内设计）：
优点：Few individuals（需要较少个体）：
由于所有参与者都经历所有实验条件，因此可以使用较少的参与者，这在样本难以获得或成本较高时特别有用。
No individual differences（无个体差异）：
因为每个参与者都经历了所有条件，个体差异在比较不同条件时会被“抵消”，从而减少了个体差异对结果的影响。
缺点：Counter-balancing needed because of ordering effects（由于顺序效应需要平衡）：
在被试内设计中，参与者会按特定顺序经历不同的实验条件，这可能导致顺序效应，即条件呈现的顺序影响参与者的反应。为了减少这种影响，需要使用平衡（counter-balancing）技术，即改变条件呈现的顺序，以确保每个条件在所有可能的位置都出现相同次数。

平衡技术可以是：
1. Counterbalancing condition orders through a Latin Square Design（通过拉丁方设计进行条件顺序的平衡）：在这种方法中，每个条件在每种可能的位置中都恰好出现一次，从而减少顺序效应。
例如，如果实验有四个条件（A、B、C、D），拉丁方设计可能如下所示：
第一个序列：A B C D
第二个序列：B C D A
第三个序列：C D A B
第四个序列：D A B C
2. Provide sufficient training time for users to get acquainted with a system to eliminate the learning effect（提供足够的训练时间让用户熟悉系统，以消除学习效应）：在实验开始之前，为参与者提供足够的时间来熟悉系统或任务，这有助于减少学习效应，即参与者随着时间的推移而提高的表现，这种提高可能与实验条件本身无关。
通过确保所有参与者都达到一定的熟练程度，可以更准确地评估实验条件对表现的影响。
3. A single experiment session should be 60-90 minutes or shorter（单个实验会话应为60-90分钟或更短）：
实验会话的时间应该控制在60到90分钟以内，或者更短。这是因为长时间的实验会话可能导致参与者疲劳，从而影响他们的表现和实验结果的可靠性。
这个建议基于Nielson在2005年的研究，该研究表明，较短的实验会话可以减少疲劳效应，提高数据质量。
![在这里插入图片描述](https://i-blog.csdnimg.cn/direct/cf20a02affc94814821a840f96c1e20e.png)

### 1.5.3 实验设计的过程
1. Identify a research hypothesis（确定研究假设）：
明确研究的目标和问题，并提出一个或多个可以测试的假设。这些假设通常是对研究问题的具体预测或解释。
2. Specify the design of the study（指定研究设计）：
根据研究问题和假设，选择合适的实验设计（如被试间设计、被试内设计等）。这包括确定自变量、因变量、控制变量以及实验条件。
3. Run a pilot study to test the design, the system, and the study instruments（进行试点研究以测试设计、系统和研究工具）：
在正式实验之前，进行一个小规模的试点研究，以测试实验设计、系统和研究工具的有效性和可靠性。这有助于发现并解决潜在的问题。
4. Recruit participants（招募参与者）：
根据研究设计的要求，招募足够数量的参与者。这可能涉及确定参与者的资格标准、发布招募广告以及筛选合适的候选人。
5. Run the actual data collection sessions（进行实际的数据收集会话）：
在正式实验中，按照实验设计收集数据。这可能包括操纵自变量、测量因变量以及记录其他相关信息。
6. Analyze the data（分析数据）：
使用适当的统计方法对收集到的数据进行分析，以检验研究假设。这可能涉及描述性统计、推断性统计以及效果大小的计算。
7. Report the results（报告结果）：
将实验结果整理成报告或论文，包括研究背景、方法、结果和讨论。报告应该清晰、准确地描述研究过程和发现，并讨论其意义和局限性。

#### 1.5.3.1 数据收集阶段的过程
1. Preparation（准备）：
在实验开始之前，确保所有实验材料、设备和程序都已准备就绪。这包括设置实验环境、检查技术设备、准备问卷和训练材料等。
2. Greet participants（迎接参与者）：
热情地欢迎参与者，并确保他们感到舒适和放松。建立良好的第一印象有助于参与者更积极地参与实验。
3. Introduce the purpose of the study and the procedures（介绍研究目的和程序）：
向参与者解释研究的目的、实验的大致过程以及他们将参与的活动。确保参与者对实验有清晰的理解。
4. Get consent（获取同意）：
让参与者签署知情同意书，表明他们自愿参与实验并了解他们的权利。这是确保参与者权益的重要步骤。
5. Assign participants to a specific experiment condition（将参与者分配到特定的实验条件）：
根据实验设计，将参与者随机分配到不同的实验条件或组别。这有助于控制变量并减少偏差。
6. Training task(s)（训练任务）：
在正式实验之前，为参与者提供必要的训练，以确保他们熟悉实验任务和程序。这有助于减少学习效应和提高数据质量。
7. Actual task(s)（实际任务）：
让参与者完成实验任务，并收集相关数据。这是实验的核心部分，需要严格按照实验设计进行。
8. Participants answer questionnaires (if any)（参与者回答问卷（如果有））：
在实验结束后，让参与者填写问卷，以收集他们的主观反馈、体验和意见。这些数据可以提供额外的见解。
9. Debriefing session（解释会话）：
在实验结束后，向参与者解释实验的真实目的、过程和发现。感谢他们的参与，并回答他们可能有的任何问题。
10. Payment (if any)（支付（如果有））：
如果事先约定，向参与者支付报酬，以感谢他们的时间和努力。这有助于提高参与者的满意度和未来参与的意愿。

下面给出一个例子。
![在这里插入图片描述](https://i-blog.csdnimg.cn/direct/edfb53c03cc34271a2c3202d39737642.png)
这里实验的目标是研究哪种AR原型能更好地激励用户学习文化遗产。
自变量是明信片AR和立方博物馆AR
因变量是用户动机。
因此我们的两种假设是：
H0: There is no difference in user motivation between the two AR prototypes.（零假设：两种AR原型在用户动机方面没有差异。）
H1: There is a difference in user motivation between the two AR prototypes.（备择假设：两种AR原型在用户动机方面存在差异。）
实验发现两者之间有统计学显著差异。
明信片AR的平均得分为3.04，标准差为0.87。
立方博物馆AR的平均得分为4.32，标准差为0.94。
t(30)=-4.001：t检验统计量，括号中的数字表示自由度（通常是样本量减一，这里是30）。
p<0.001：p值小于0.001，表示结果具有高度统计学显著性。通常，p值小于0.05被认为是显著的，而小于0.001则表示结果非常显著。
因此我们得出了结论：立方博物馆AR在激励用户学习文化遗产方面显著优于明信片AR。
如果实验发现两者之间没有统计学显著差异。
t(30)=-0.740：t检验统计量。
p=0.465：p值大于0.05，表示结果没有统计学显著性。
因此我们得出了结论：两种AR原型在激励用户学习文化遗产方面没有显著差异。
除了文本描述，研究者还可以使用图表（如柱状图、折线图）和表格来直观地展示数据和结果。这有助于读者更清晰地理解数据分布和统计分析结果。

## 1.6 数据分析
我们可以使用excel进行数据分析，用excel里面的函数对数据进行样本量计数、计算平均值、计算标准差等、进行F验证、进行t验证等。

