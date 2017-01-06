<%@ page contentType="text/html;charset=UTF-8" %>

<div id="main">
	<h1>
		编辑权限信息
	</h1>
	<p>
	</p>
	<form action="save.do" method="post">
		<input type="hidden" name="id" value="${id }"/>
		<fieldset>
			<dl>
				<dt>
					<label for="username">
						权限值:
					</label>
					<br>
					<span></span>
				</dt>
				<dd>
					<input type="text" name="permission.value" value="${permission.value }"/>
					${errorMap.value}
				</dd>
			</dl>
		</fieldset>
		<br>
		<input type="submit" value="提交" class="button2" />
	</form>
</div>