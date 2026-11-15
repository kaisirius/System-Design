package LLD.Problems.Splitwise.factory;

import javax.naming.directory.InvalidAttributeValueException;

import LLD.Problems.Splitwise.enums.SplitType;
import LLD.Problems.Splitwise.strategy.EqualSplitStrategy;
import LLD.Problems.Splitwise.strategy.ExactSplitStratgey;
import LLD.Problems.Splitwise.strategy.ISplitStrategy;
import LLD.Problems.Splitwise.strategy.PercentageSplitStrategy;

public class SplitMethodFactory {
  public static ISplitStrategy createSplitMethod(SplitType type) throws Exception {
    if(type == SplitType.EQUAL) {
      return new EqualSplitStrategy();
    } else if(type == SplitType.EXACT) {
      return new ExactSplitStratgey();
    } else if(type == SplitType.PERCENTAGE) {
      return new PercentageSplitStrategy();
    } else {
      throw new InvalidAttributeValueException();
    }
  }
}
