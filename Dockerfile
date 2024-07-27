FROM alpine:3.18.5

# Prepare environment
ENV AWS_ACCESS_KEY_ID 'non_empty_key'
ENV AWS_SECRET_KEY 'non_empty_key'
ENV AWS_SECRET_ACCESS_KEY 'non_empty_key'
ENV AWS_REGION 'ap-southeast-1'