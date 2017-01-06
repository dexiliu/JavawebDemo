<%@ page contentType="text/html;charset=UTF-8" %>

<div id="main">
	<h1>
		编辑学生信息
	</h1>
	<p>
	</p>
	<form action="save.do" method="post">
		<input type="hidden" name="id" value="${id }"/>
		<fieldset>
			<dl>
				<dt>
					<label for="username">
						Name:
					</label>
					<br>
					<span></span>
				</dt>
				<dd>
					<input type="text" name="student.name" value="${student.name }"/>
					${errorMap.name}
				</dd>
			</dl>
			<dl>
				<dt>
					<label for="username">
						Email:
					</label>
					<br>
					<span></span>
				</dt>
				<dd>
					<input type="text" name="student.email" value="${student.email }"/>
					${errorMap.email}
				</dd>
			</dl>
		</fieldset>
		<br>
		<input type="submit" value="提交" class="button2" />
	</form>
</div>