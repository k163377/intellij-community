import abc
import re
from typing import List, Type, Optional
from data_processing.datapoint import CodeDataPoint
from data_processing.processors.abstract_processor import ProcessorBase
class EmptyLineRemoverBase(ProcessorBase):⇥__EMPTY_LINE_REGEX = re.compile(r"\n\s*\n")
def _remove_empty_lines(self, dp: CodeDataPoint, keep_last: bool) -> CodeDataPoint:⇥lines = dp.content.split("\n")
new_lines = [line for line in lines[:-1] if line.strip()]
if lines[-1].strip() or keep_last:⇥new_lines.append(lines[-1])⇤dp.content = "\n".join(new_lines)
return dp⇤@abc.abstractmethod
def _process(self, dp: CodeDataPoint) -> Optional[CodeDataPoint]:⇥raise NotImplementedError⇤@staticmethod
def is_deterministic() -> bool:⇥return True⇤@staticmethod
def is_slow() -> bool:⇥return False⇤@staticmethod
def must_be_after() -> List[Type[ProcessorBase]]:⇥return []⇤@staticmethod
def must_be_before() -> List[Type[ProcessorBase]]:⇥return []⇤⇤class EmptyLineRemoverTrainData(EmptyLineRemoverBase):⇥def _process(self, dp: CodeDataPoint) -> Optional[CodeDataPoint]:⇥return self._remove_empty_lines(dp, keep_last=True)⇤⇤class EmptyLineRemoverTrainModel(EmptyLineRemoverBase):⇥def _process(self, dp: CodeDataPoint) -> Optional[CodeDataPoint]:⇥return self._remove_empty_lines(dp, keep_last=True)⇤⇤class EmptyLineRemoverInference(EmptyLineRemoverBase):⇥def _process(self, dp: CodeDataPoint) -> Optional[CodeDataPoint]:⇥return self._remove_empty_lines(dp, keep_last=True)⇤⇤