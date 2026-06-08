There are two designs in same UML image. One is using CoR design pattern and other one is naive. Having each and every function can vioulate OCP principle, hence imo CoR one is better. To introduce formatting,have a LogConfig class having LogAppender, LogFormatter etc.<br>

Also what I prefer to have is just like in CoR uml, here the logic to decide which node on chain will handle is same hence you can keep it in parent class like as it is now but then call the abstract method write() (or give other name like log()) which will take LogConfig from parent class and does it's processing like formatting and appending etc.<br>

Additionaly can have LogManager as singleton class for single point of contact to Logs.