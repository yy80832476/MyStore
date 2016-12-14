package cn.yy.blog.handler;

import com.github.sd4324530.fastweixin.handle.MessageHandle;
import com.github.sd4324530.fastweixin.message.BaseMsg;
import com.github.sd4324530.fastweixin.message.TextMsg;
import com.github.sd4324530.fastweixin.message.req.TextReqMsg;

public class TextMsgHandle implements MessageHandle<TextReqMsg> {

	@Override
	public boolean beforeHandle(TextReqMsg msg) {
		return true;
	}

	@Override
	public BaseMsg handle(TextReqMsg msg) {
		System.out.println("收到微信文字请求：" + msg);
        String content = msg.getContent();
        return new TextMsg("你好" + msg.getFromUserName() + ", 收到：" + content);
	}

}
