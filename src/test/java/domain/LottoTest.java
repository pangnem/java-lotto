package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

	private Lotto winningLotto;

	@BeforeEach
	void setUp() {
		winningLotto = new Lotto(Arrays.asList(new Number(1),new Number(2),new Number(3), new Number(4), new Number(5),
						new Number(6)));
	}

	@DisplayName("로또의 사이지를 잘 반환하는 지 확인하는 테스트")
	@Test
	void test_lotto_size() {
		Lotto lotto = new Lotto(Arrays.asList(new Number(1),new Number(2),new Number(3), new Number(4), new Number(5),
						new Number(6)));
		assertThat(lotto.size()).isEqualTo(6);
	}

	@DisplayName("로또가 얼마나 맞았는지 반환하는 테스트")
	@Test
	void test_lotto_match() {
		Lotto lotto = new Lotto(Arrays.asList(new Number(1),new Number(2),new Number(3), new Number(4), new Number(5),
						new Number(6)));
		Integer matchNumber = Lotto.numberOfMatches(lotto,winningLotto);
		assertThat(matchNumber).isEqualTo(6);
	}

	@DisplayName("로또에 보너스 점수가 맞는지 확인하는 테스트")
	@Test
	void test_lotto_bonus() {
		Lotto lotto = new Lotto(Arrays.asList(new Number(1),new Number(2),new Number(3), new Number(4), new Number(5),
						new Number(6)));
		boolean bonusStatus = Lotto.bonusNumberOfMatches(lotto, new Number(3));
		assertThat(bonusStatus).isEqualTo(true);
	}
}
