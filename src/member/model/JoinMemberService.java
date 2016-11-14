package member.model;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * 	ȸ�������� �����ִ� ���� �� ��ӽ�����Ʈ ����
 */
@Component
public class JoinMemberService {
	@Autowired
	SqlSessionFactory fac;

	public boolean joinmember(HashMap map) {
		SqlSession sql = fac.openSession();
		int excute = sql.insert("member.addMember", map);
		if (excute == 1) {
			HashMap map2 = new HashMap();
			map2.put("id", map.get("id"));
			map2.put("name", map.get("name"));
			int excute2 = sql.insert("member.addMembership", map2);
			if (excute2 == 1) {
				return true;
			}
		} else {
			return false;
		}
		return false;
	}
}
